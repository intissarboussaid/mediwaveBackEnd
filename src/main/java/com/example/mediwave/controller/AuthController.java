package com.example.mediwave.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.mediwave.modal.Account;
import com.example.mediwave.modal.User;
import com.example.mediwave.payload.request.LoginRequest;
import com.example.mediwave.payload.request.SignUpRequest;
import com.example.mediwave.payload.response.JwtResponse;
import com.example.mediwave.payload.response.MessageResponse;
import com.example.mediwave.repository.AccountRepository;
import com.example.mediwave.repository.UserRepository;
import com.example.mediwave.service.EmailService;
import com.example.mediwave.service.JwtUtils;
import com.example.mediwave.service.UserDetailsImpl;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
	@Autowired
	AuthenticationManager authenticationManager;
	@Autowired
	AccountRepository accountRepository;
	@Autowired
	UserRepository userRepository;
	@Autowired
	 EmailService emailService;
	@Autowired
	PasswordEncoder encoder;
	@Autowired
	JwtUtils jwtUtils;
	
	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

		Authentication authentication = authenticationManager.authenticate(
		new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword() ));

       SecurityContextHolder.getContext().setAuthentication(authentication);
String jwt = jwtUtils.generateJwtToken(authentication);

UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();	
Account account =accountRepository.findBysername(loginRequest.getUsername());
User user = userRepository.findByAccount(account);
System.out.println("user enable : "+account.isEnable());
com.example.mediwave.modal.Role roleUser = account.getRole();

return ResponseEntity.ok(new JwtResponse(jwt, 
										 userDetails.getId(), 
										 userDetails.getUsername(), 
										 userDetails.getEmail(), 
										 account.isEnable(),
										 user.getIduser(),
										 roleUser));
}

	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpRequest signUpRequest, ModelAndView modelAndView) {
		if (accountRepository.existsByUsername(signUpRequest.getUsername())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Username is already taken!"));
		}

		if (accountRepository.existsByEmail(signUpRequest.getEmail())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Email is already in use!"));
		}

		// Create new user's account
		Account account = new Account(signUpRequest.getUsername(), 
							 signUpRequest.getEmail(),
							 encoder.encode(signUpRequest.getPassword()));
		System.out.println("test"+signUpRequest.getUsername());

		/*Set<String> strRoles = signUpRequest.getRole();
		Set<Role> roles = new HashSet<>();

		if (strRoles == null) {
			Role userRole = roleRepository.findByName(ERole.ROLE_USER)
					.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
			roles.add(userRole);
		} else {
			strRoles.forEach(role -> {
				switch (role) {
				case "admin":
					Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(adminRole);

					break;
				case "mod":
					Role modRole = roleRepository.findByName(ERole.ROLE_MODERATOR)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(modRole);

					break;
				default:
					Role userRole = roleRepository.findByName1(ERole.ROLE_USER);
							//n.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(userRole);
				}
			});
		}

		user.setRoles(roles);*/
		account.setEmail(signUpRequest.getEmail());
		account.setEnable(false);
		Account ac =accountRepository.save(account);
		User user =new User(ac);
		userRepository.save(user);
	    	System.out.println("test"+signUpRequest.getEmail());
	    	System.out.println("test"+signUpRequest.getPassword());
	    	System.out.println("test enable"+account.isEnable());
	     SimpleMailMessage mailMessage = new SimpleMailMessage();
	     mailMessage.setTo(account.getEmail());
	     mailMessage.setSubject("Active Account!");
	     mailMessage.setFrom("intissarboussaid2@gmail.com");
	     mailMessage.setText("Dear '"+signUpRequest.getUsername()+"'"
	     		+ "We are writing to confirm that your account is currently active and fully functional and Activate your account via the link below. We appreciate your continued use of our services and are here to assist you if you have any questions or concerns.\r\n"
	     		+ "\r\n"
	     		+ "Please keep in mind that your account is subject to our terms and conditions, which can be found on our website. If you have any questions regarding these terms or need assistance with your account, please do not hesitate to contact our support team.\r\n"
	     		+ "\r\n"
	     		+ "Thank you for choosing our services. "
	     		+"Thank you for choosing our services."

	     		+"Best regards,"
	     +"http://localhost:4200/ActiveAccount" );

	     emailService.sendEmail(mailMessage);

	     modelAndView.addObject("email", account.getEmail());

	     modelAndView.setViewName("successfulRegisteration");
		

		return ResponseEntity.ok(account);
	}
	
	//Active Account
	
	@PutMapping("/ActiveAccount/{username}")
	public Account ActiveAccount(@PathVariable(value = "username")String username) {
		Account user = accountRepository.findBysername(username);
		
			user.setEnable(true);
			return accountRepository.save(user);	
	}
	
	//Get Email 
	@GetMapping("/email/{email}")
	public  Account getEmail(@PathVariable("email") String email){
		Account account =accountRepository.findByemail(email); 
		
			 SimpleMailMessage mailMessage = new SimpleMailMessage();
		     mailMessage.setTo(account.getEmail());
		     mailMessage.setSubject("Rest password!");
		     mailMessage.setFrom("intissarboussaid2@gmail.com");
		     mailMessage.setText(
		    		"We received a request to rest your password.,\r\n"
		     		+ "Use the link below to set up a new password for your account.\r\n"
		     		+ "if you did not request to reset your password, ignore this email and the link will expire on this own. "
		     		
		     +"http://localhost:4200/forgotpassword    ");

		     emailService.sendEmail(mailMessage);
		   return account;
		 
	}
	//Forgot Password
	@PutMapping("forgetpassword/{email}")
	public Account ForgetPassword(@PathVariable(value = "email")String email, @Validated @RequestBody Account account) {
		Account user = accountRepository.findByemail(email);
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(account.getPassword());
         String confPass=passwordEncoder.encode(account.getConfirmationpassword());
        user.setPassword(encodedPassword);
		user.setConfirmationpassword(confPass)	;
		
			return accountRepository.save(user);
			   
		
	}
	
	/*@DeleteMapping("delete/{idAdmin}")
	public String DeleteAccount(@PathVariable(value = "idAdmin")long idAdmin) {
		Admin admin =adminRepository.findById(idAdmin);
		 if (admin==null )
			 return "sorry we don't have user with that identity ";
		Account account=admin.getAccount();
		 if (account==null )
			 return "sorry that user haven't account";
		Account deleteaccount=accountRepository.findById1(account.getIdaccount());
		 if (deleteaccount==null )
			 return "sorry that user haven't account to delete it";
		List<Product> products = productRepository.findByIdAdmin(admin);
		System.out.println("products "+products);
		for(Product product :products ) {
			
			productRepository.delete(product);
			System.out.println("product "+product);	
			 if (products==null )
				 return "sorry that user haven't Product's";
		}
		System.out.println("products "+products);
		adminRepository.delete(admin);
		accountRepository.delete(deleteaccount);
		adminRepository.delete(admin);
		 if (account==null && deleteaccount==null )
				 return "we delete that user";
		 else
			 return "error!";
	}*/
	

	
	
}
