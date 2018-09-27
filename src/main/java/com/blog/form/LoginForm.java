package com.blog.form;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

import com.blog.model.User;

public class LoginForm {
	@Size(min = 3, max = 10)
	private String name;
	@Size(min = 6, max = 15)
	private String password;
	@Email
	private String email;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public User toUser(){
		return new User(name, email, password);
	}
}
