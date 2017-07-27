package com.mrinal.response;

public class UserResponse extends GenericResponse {

	private String status;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	private String successMessage;
	private String errorMessage;
	private String firstName;
	private String lastName;
	private String emailId;
	private String password;
	public UserResponse(String status, String successMessage, String firstName, String lastName,
			String emailId, String password, String userId) {
		super();
		this.status = status;
		this.successMessage = successMessage;
		this.errorMessage = errorMessage;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.password = password;
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	private String userId;
	public String getSuccessMessage() {
		return successMessage;
	}
	public void setSuccessMessage(String successMessage) {
		this.successMessage = successMessage;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
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
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public UserResponse(String status, String successMessage, String firstName, String lastName, String emailId,
			String userId) {
		super();
		this.status = status;
		this.successMessage = successMessage;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.userId = userId;
	}
	
	public UserResponse(String status, String errorMessage) {
		super();
		this.status = status;
		this.errorMessage = errorMessage;
	}
	public UserResponse() {
		super();
	}
	
}
