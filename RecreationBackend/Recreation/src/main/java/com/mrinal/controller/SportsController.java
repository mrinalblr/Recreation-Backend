package com.mrinal.controller;

import java.util.ArrayList;

import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mrinal.model.Sports;
import com.mrinal.repo.SportsRepo;
import com.mrinal.response.SpecificSportsResponse;
import com.mrinal.response.SportsResponse;
import com.mrinal.response.UserResponse;

@RestController
@RequestMapping("/sports")
public class SportsController {

	@Autowired
	SportsRepo sp;
	
	//@CrossOrigin(origins = "http://localhost:8100", maxAge = 7200)
	/*@RequestMapping(value="/getAllSports",method =RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<SportsResponse> getSports(@RequestBody Sports sports){
		ArrayList<Sports> list = new ArrayList<Sports>();
		Sports newSports=null;
		SportsResponse response = null;
		try{
			if(sports.getSportsName()!=null){
				newSports = (Sports) sp.findBySportsName(sports.getSportsName());
				response = new SportsResponse("SUCCESS", "Sports Fetched Successfully", "None", newSports.getSportsName(), newSports.getHost(), newSports.getVenue(), newSports.getDate(), newSports.getTime(), newSports.getDescription());
			}
		}
		catch(Exception e){
			e.printStackTrace();
			response = new SportsResponse("FAILURE","Unable to Fetch");
      	  return new ResponseEntity<SportsResponse>(response, HttpStatus.OK);
		}
		
		return new ResponseEntity<SportsResponse>(response, HttpStatus.OK);
	}*/
	@CrossOrigin(origins = "http://localhost:8100", maxAge = 7200)
	@RequestMapping(value="/getAllSports",method =RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<SpecificSportsResponse> getSports(@RequestBody Sports sports){
	
		SpecificSportsResponse response = null;
		ArrayList<Sports> fetchedSports=null;
		try{
			if(sports.getSportsName()!=null){
				 fetchedSports = sp.findAllBySportsName(sports.getSportsName());
				 response = new SpecificSportsResponse("SUCCESS","Sports List Fetched Successfully","None",fetchedSports);
			}
		}catch(Exception e){
			e.printStackTrace();
			response = new SpecificSportsResponse("SUCCESS","UNABLE TO FETCH", "FAILURE");
		}
		
		
		return new ResponseEntity<SpecificSportsResponse>(response, HttpStatus.OK);
	}
	
	
	
	
//	main.....
	@CrossOrigin(origins = "http://localhost:8100", maxAge = 7200)
	@RequestMapping(value="/addSports",method =RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<SportsResponse> addSports(@RequestBody Sports sports){
		
		Sports newSports=new Sports();
		SportsResponse response = null;
		String sportsId="";
		try{
			if(sports!=null){
				newSports.setSportsName(sports.getSportsName());
				newSports.setHost(sports.getHost());
				newSports.setVenue(sports.getVenue());
				newSports.setDate(sports.getDate());
				newSports.setTime(sports.getTime());
				newSports.setDescription(sports.getDescription());
				sp.save(newSports);
				sportsId = String.valueOf(newSports.getSportsId());
				response = new SportsResponse(sportsId, "SUCCESS","Sports added Successfully","None", newSports.getSportsName(), newSports.getHost(), newSports.getVenue(), newSports.getDate(),newSports.getTime(),newSports.getDescription());
			}
		}
		catch(Exception e){
			e.printStackTrace();
			response = new SportsResponse("FAILURE","Unable to add sport");
      	  return new ResponseEntity<SportsResponse>(response, HttpStatus.OK);
		}
		
		return new ResponseEntity<SportsResponse>(response, HttpStatus.OK);
	}
}
