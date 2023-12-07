package com.example.mediwave.modal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="account")
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)	
	private long idaccount;
	@Column(name = "username")
	private String username;
	@Column(name = "password")
	private String password;
	@Column(name = "confirmationpassword")
	private String confirmationpassword;
	@Column(name = "email")
	private String email;
	@Column(name="enable")
    boolean enable;
	@ManyToOne
    @JoinColumn(name="role")
    private Role role;
	
	public long getIdaccount() {
		return idaccount;
	}
	public void setIdaccount(long idaccount) {
		this.idaccount = idaccount;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isEnable() {
		return enable;
	}
	public void setEnable(boolean enable) {
		this.enable = enable;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Account(String email, String username, String password, boolean enable) {
		super();
		this.email = email;
		this.username = username;
		this.password = password;
		this.enable = enable;
	}
	
	public String getConfirmationpassword() {
		return confirmationpassword;
	}
	public void setConfirmationpassword(String confirmationpassword) {
		this.confirmationpassword = confirmationpassword;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public Account() {
		super();
	}
	public Account(String username, String password, String email, boolean enable, Role role) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.enable = enable;
		this.role = role;
	}

	public Account(String username, String password, String email) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
	}
	public Account(long idaccount, String username, String password, String confirmationpassword, String email,
			boolean enable, Role role) {
		super();
		this.idaccount = idaccount;
		this.username = username;
		this.password = password;
		this.confirmationpassword = confirmationpassword;
		this.email = email;
		this.enable = enable;
		this.role = role;
	}
	

}
