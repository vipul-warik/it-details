package com.demo.it.services;

import java.util.List;

import com.demo.it.models.PersonalDetails;

public interface PersonalDetailsService {
	
	PersonalDetails savePersonalDetails(PersonalDetails personalDetails,long employeeId);
	
	PersonalDetails getPersonalDetailsById(long personalDetails_id);
	
	List<PersonalDetails> getAllPersonalDetailss();
	
	PersonalDetails updatePersonalDetails(PersonalDetails personalDetails,long personalId);
	
	PersonalDetails deletePersonalDetails(long personalDetails_id);
}
