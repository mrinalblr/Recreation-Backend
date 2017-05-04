package com.mrinal.service;

import java.util.Hashtable;
import org.springframework.stereotype.Service;

import com.mrinal.model.User;

@Service
public class UserService {

	Hashtable<String, User> users = new Hashtable<String, User>();
	
	public UserService(){
	   /* User u = new User();
	    u.setId(1);
	    u.setFirstName("Mrinal");
	    u.setLastName("Gupta");
	    u.setAge(24);
	    users.put(1,u);
	    
	    u = new User();
	    u.setId(2);
	    u.setFirstName("Rahul");
	    u.setLastName("Deo");
	    u.setAge(28);
	    users.put("2",u);*/
	}
	
	public User getUser(int id){
		if(users.containsKey(id)){
			return users.get(id);
		}
		else{
		      return null;
	     }
	}
	public Hashtable<String, User> getAll(){
		return users;
	}
}
