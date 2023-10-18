package com.demo.it.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.it.exceptions.ResourceNotFoundException;
import com.demo.it.models.Employee;
import com.demo.it.models.PersonalDetails;
import com.demo.it.repositories.EmployeeRepository;
import com.demo.it.repositories.PersonalDetailsRepository;
import com.demo.it.services.PersonalDetailsService;

@Service
public class PersonalDetailsServiceImpl implements PersonalDetailsService {
	
	@Autowired
	private PersonalDetailsRepository personalDetailsRepository;
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public PersonalDetails savePersonalDetails(PersonalDetails personalDetails,long employeeId) {
		
		Employee employee = employeeRepository.findById(employeeId).orElseThrow(() -> new ResourceNotFoundException("Employee", "Id", employeeId));
		
		personalDetails.setEmployee(employee);
		
		return personalDetailsRepository.save(personalDetails);
	}

	@Override
	public PersonalDetails getPersonalDetailsById(long personalDetails_id) {
		PersonalDetails personalDetails = personalDetailsRepository.findById(personalDetails_id).orElseThrow(() -> new ResourceNotFoundException("PersonalDetails", "Id", personalDetails_id));
		
		return personalDetails;
	}

	@Override
	public List<PersonalDetails> getAllPersonalDetailss() {
		
		return personalDetailsRepository.findAll();
	}

	@Override
	public PersonalDetails updatePersonalDetails(PersonalDetails personalDetails,long personalId) {
		PersonalDetails existingPersonalDetails = personalDetailsRepository.findById(personalId).orElseThrow(() -> new ResourceNotFoundException("PersonalDetails", "Id", personalId));
		
		existingPersonalDetails.setAddress(personalDetails.getAddress());
		existingPersonalDetails.setBithDate(personalDetails.getBithDate());
		existingPersonalDetails.setBloodGroup(personalDetails.getBloodGroup());
		existingPersonalDetails.setGender(personalDetails.getGender());
		existingPersonalDetails.setMobileNo(personalDetails.getMobileNo());
		
		personalDetailsRepository.save(existingPersonalDetails);
		
		return existingPersonalDetails;
	}

	@Override
	public PersonalDetails deletePersonalDetails(long personalDetails_id) {
		PersonalDetails personalDetails = personalDetailsRepository.findById(personalDetails_id).orElseThrow(() -> new ResourceNotFoundException("PersonalDetails", "Id", personalDetails_id));
		
		personalDetailsRepository.delete(personalDetails);
		
		return personalDetails;
	}

}
