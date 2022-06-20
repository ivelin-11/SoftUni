package com.softuni.mobilele.model.dto;

public class UserRegisterDTO {

	private String email;

	private String firstName;

	private String lastName;

	private String password;

	private String confirmPassoword;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public UserRegisterDTO() {

	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassoword() {
		return confirmPassoword;
	}

	public void setConfirmPassoword(String confirmPassoword) {
		this.confirmPassoword = confirmPassoword;
	}

}
