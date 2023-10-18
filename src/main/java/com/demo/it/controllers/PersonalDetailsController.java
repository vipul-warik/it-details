package com.demo.it.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.it.models.PersonalDetails;
import com.demo.it.services.PersonalDetailsService;



@RestController
@RequestMapping("/api/personalDetails")
public class PersonalDetailsController {
	
	@Autowired
	private PersonalDetailsService personalDetailsService;

	
	//Home Page
		@GetMapping()
		public String start() {
			
			return "Home Page";
		}
		
	// build create personalDetails REST API
	@PostMapping("/save/{id}")
	public ResponseEntity<PersonalDetails> savePersonalDetails(@RequestBody PersonalDetails personalDetails,@PathVariable("id") long employeeId){

		return new ResponseEntity<PersonalDetails>(personalDetailsService.savePersonalDetails(personalDetails,employeeId), HttpStatus.CREATED);
	}
	
	// build get all personalDetailss REST API
	@GetMapping("/get-all")
	public ResponseEntity<List<PersonalDetails>> getAllPersonalDetailss(){
		return new ResponseEntity<List<PersonalDetails>>(personalDetailsService.getAllPersonalDetailss(), HttpStatus.OK);
	}
	
	//build get PersonalDetails by ID REST API 
	@GetMapping("/get-personalDetails/{id}")
	public ResponseEntity<PersonalDetails> getPersonalDetailsById(@PathVariable("id") long personalDetailsId){
		return new ResponseEntity<PersonalDetails> (personalDetailsService.getPersonalDetailsById(personalDetailsId), HttpStatus.OK);
	}
	
	
	//build update PersonalDetails REST API
	@PutMapping("/update-personalDetails/{id}")
	public ResponseEntity<PersonalDetails> updatePersonalDetails(@RequestBody PersonalDetails personalDetails,@PathVariable("id") long personalId){
		return new ResponseEntity<PersonalDetails> (personalDetailsService.updatePersonalDetails(personalDetails,personalId), HttpStatus.OK);
	}
	 
	
	//build delete PersonalDetails REST API
	@DeleteMapping("delete-personalDetails/{id}")
	public ResponseEntity<PersonalDetails> deletePersonalDetails(@PathVariable("id") long personalDetailsId){
		return new ResponseEntity<PersonalDetails> (personalDetailsService.deletePersonalDetails(personalDetailsId), HttpStatus.OK);
	}
	

}
 
