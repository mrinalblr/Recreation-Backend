package com.mrinal.model;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity(name="USER")
public class User {
 
	@Id
	@Column(name="USER_ID")
	@GeneratedValue (strategy = GenerationType.AUTO)
	private int id;
	@Column(name="USER_FIRSTNAME")
	private String firstName;
	@Column(name="USER_LASTNAME")
	private String lastName;
	@Column(name="USER_EMAILID",unique=true)
	private String emailId;
	@Column(name="USER_PASSWORD")
	private String password;
	
	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL, 
            fetch = FetchType.LAZY, optional = false)
	private UserDetails userDetails;
   

	public User(String firstName, String lastName, String emailId, String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.password = password;
	}

	public UserDetails getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getId() {
		return id;
	}
	
	
	
	public User() {
		super();
	}
	
	public User(String firstName, String lastName) {
		// TODO Auto-generated constructor stub
		this.firstName=firstName;
		this.lastName=lastName;
		
	}

	
	public void setId(int id) {
		this.id = id;
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

	
	
	
	
}
