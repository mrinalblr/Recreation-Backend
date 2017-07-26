package com.mrinal.response;

import java.util.ArrayList;

import com.mrinal.model.Sports;

public class SpecificSportsResponse {
    
	private String status;
	private String successMessage;
	private String errorMessage;
	private ArrayList<Sports> sportsList;
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
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
	public ArrayList<Sports> getSportsList() {
		return sportsList;
	}
	public void setSportsList(ArrayList<Sports> sportsList) {
		this.sportsList = sportsList;
	}
	public SpecificSportsResponse(String status, String successMessage, String errorMessage,
			ArrayList<Sports> sportsList) {
		super();
		this.status = status;
		this.successMessage = successMessage;
		this.errorMessage = errorMessage;
		this.sportsList = sportsList;
	}
	public SpecificSportsResponse(String status, String successMessage, String errorMessage) {
		super();
		this.status = status;
		this.successMessage = successMessage;
		this.errorMessage = errorMessage;
	}
	
	
	
	
}

