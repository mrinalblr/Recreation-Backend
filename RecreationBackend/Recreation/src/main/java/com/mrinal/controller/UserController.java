package com.mrinal.controller;

import java.util.Hashtable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mrinal.model.User;
import com.mrinal.repo.UserRepo;
import com.mrinal.response.UserResponse;
import com.mrinal.service.UserService;


@RestController
@RequestMapping("/users")
public class UserController {
    
	@Autowired
	UserService us;
	@Autowired
	UserRepo rp;
	
	@RequestMapping("/all")
	public Hashtable<String, User> getAll(){
		return us.getAll();
	}
	@RequestMapping("{id}")
	public User getUser(@PathVariable("id") int id){
		return us.getUser(id);
	}
	
	@RequestMapping("/create")
	@ResponseBody
	public String createUser(String firstName,String lastName,String emailId,String password){
		String userId="";
		try{
			User user = new User(firstName,lastName,emailId,password);
			rp.save(user);
	        userId = String.valueOf(user.getId());
	        
		}
		catch(Exception e){
			return "Error Creating the User : "+e.toString();
		}
		return "User Successfully created with id = "+userId;
	}
	
	@RequestMapping("/get-by-emailId")
	  @ResponseBody
	  public User getByFirstName(String emailId) {
	    String userId = "";
	    User user=null;
	    try {
	       user = rp.findByemailId(emailId);
	      userId = String.valueOf(user.getId());
	      user = (User) rp.findAll();
	    }
	    catch (Exception ex) {
	      
	    }
	    return user;
	  } 
	@CrossOrigin(origins = "http://localhost:8100", maxAge = 7200)
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<UserResponse> login(@RequestBody User user) {
          User newUser = new User();
          UserResponse response =null;
          String userId="";
          try{
	          if (user.getEmailId() != null) {
	    	    newUser=(User)rp.findByemailId(user.getEmailId());
	    	    userId = String.valueOf(newUser.getId());
	             response= new UserResponse("SUCCESS","Successfully loggedIn",newUser.getFirstName(),newUser.getLastName(),
	        		 newUser.getEmailId(),newUser.getPassword(),userId);
	    }
	    
          }
          catch(Exception e){
        	  response = new UserResponse("FAILURE","Unable to login");
        	  return new ResponseEntity<UserResponse>(response, HttpStatus.OK);
          }

	   
	    return new ResponseEntity<UserResponse>(response, HttpStatus.OK);
	}
	@CrossOrigin(origins = "http://localhost:8100", maxAge = 7200)
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseEntity<UserResponse> register(@RequestBody User user) {
          User newUser = new User();
          UserResponse response =null;
          String userId="";
          try{
	          if (user != null) {
	    	     newUser.setFirstName(user.getFirstName());
	    	     newUser.setLastName(user.getLastName());
	    	     newUser.setEmailId(user.getEmailId());
	             newUser.setPassword(user.getPassword());
	             rp.save(newUser);
	             userId = String.valueOf(newUser.getId());
	             response= new UserResponse("SUCCESS","Successfully registered",newUser.getFirstName(),newUser.getLastName(),
	        		 newUser.getEmailId(),userId);
	    }
	    
          }
          catch(Exception e){
        	  response = new UserResponse("FAILURE","Unable to register User");
        	  return new ResponseEntity<UserResponse>(response, HttpStatus.OK);
          }

	   
	    return new ResponseEntity<UserResponse>(response, HttpStatus.OK);
	}
}
