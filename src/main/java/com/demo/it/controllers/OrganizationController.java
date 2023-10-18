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

import com.demo.it.models.Organization;
import com.demo.it.services.OrganizationService;



@RestController
@RequestMapping("/api/organizations")
public class OrganizationController {
	
	@Autowired
	private OrganizationService organizationService;

	
	//Home Page
		@GetMapping()
		public String start() {
			
			return "Home Page";
		}
		
	// build create organization REST API
	@PostMapping("/save")
	public ResponseEntity<Organization> saveOrganization(@RequestBody Organization organization){

		return new ResponseEntity<Organization>(organizationService.saveOrganization(organization), HttpStatus.CREATED);
	}
	
	// build get all organizations REST API
	@GetMapping("/get-all")
	public ResponseEntity<List<Organization>> getAllOrganizations(){
		return new ResponseEntity<List<Organization>>(organizationService.getAllOrganizations(), HttpStatus.OK);
	}
	
	//build get Organization by ID REST API 
	@GetMapping("/get-organization/{id}")
	public ResponseEntity<Organization> getOrganizationById(@PathVariable("id") long organizationId){
		return new ResponseEntity<Organization> (organizationService.getOrganizationById(organizationId), HttpStatus.OK);
	}
	
	
	//build update Organization REST API
	@PutMapping("/update-organization/{id}")
	public ResponseEntity<Organization> updateOrganization(@RequestBody Organization organization,@PathVariable("id") long organizationId){
		return new ResponseEntity<Organization> (organizationService.updateOrganization(organization,organizationId), HttpStatus.OK);
	}
	 
	
	//build delete Organization REST API
	@DeleteMapping("delete-organization/{id}")
	public ResponseEntity<Organization> deleteOrganization(@PathVariable("id") long organizationId){
		return new ResponseEntity<Organization> (organizationService.deleteOrganization(organizationId), HttpStatus.OK);
	}
	

}
 