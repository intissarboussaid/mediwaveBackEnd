package com.example.mediwave.payload.request;

import java.util.Set;

import jakarta.persistence.Column;
public class SignUpRequest {
		@Column
	    private String username;
	 
	    
		@Column
	    private String email;
	    
	    private Set<String> role;
	    
	  
	    @Column
	    private String password;
	    @Column(name="enable")
	    private boolean enable;
	  
	    
	    public String getUsername() {
	        return username;
	    }
	 
	    public void setUsername(String username) {
	        this.username = username;
	    }
	 
	    public String getEmail() {
	        return email;
	    }
	 
	    public void setEmail(String email) {
	        this.email = email;
	    }
	 
	    public String getPassword() {
	        return password;
	    }
	 
	    public void setPassword(String password) {
	        this.password = password;
	    }
	    
	    public Set<String> getRole() {
	      return this.role;
	    }
	    
	    public void setRole(Set<String> role) {
	      this.role = role;
	    }

		public boolean isEnable() {
			return enable;
		}

		public void setEnable(boolean enable) {
			this.enable = enable;
		}

		public SignUpRequest(String username, String email, Set<String> role, String password, boolean enable) {
			super();
			this.username = username;
			this.email = email;
			this.role = role;
			this.password = password;
			this.enable = enable;
		}
		
	    
	    
	}
