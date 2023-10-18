package com.demo.it.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.it.exceptions.ResourceNotFoundException;
import com.demo.it.models.Organization;
import com.demo.it.repositories.OrganizationRepository;
import com.demo.it.services.OrganizationService;

@Service
public class OrganizationServiceImpl implements OrganizationService {
	
	@Autowired
	private OrganizationRepository organizationRepository;

	@Override
	public Organization saveOrganization(Organization organization) {
		
		return organizationRepository.save(organization);
	}

	@Override
	public Organization getOrganizationById(long organization_id) {
		Organization organization = organizationRepository.findById(organization_id).orElseThrow(() -> new ResourceNotFoundException("Organization", "Id", organization_id));
		
		return organization;
	}

	@Override
	public List<Organization> getAllOrganizations() {
		
		return organizationRepository.findAll();
	}

	@Override
	public Organization updateOrganization(Organization organization,long org_id) {
		Organization existingOrg = organizationRepository.findById(org_id).orElseThrow(() -> new ResourceNotFoundException("Organization", "Id", org_id));
		existingOrg.setName(organization.getName());
		existingOrg.setAddress(organization.getAddress());
		existingOrg.setBranch(organization.getBranch());
		existingOrg.setSector(organization.getSector());
	
		
		organizationRepository.save(existingOrg);
		
		return existingOrg;
	}

	@Override
	public Organization deleteOrganization(long organization_id) {
		Organization organization = organizationRepository.findById(organization_id).orElseThrow(() -> new ResourceNotFoundException("Organization", "Id", organization_id));
		
		organizationRepository.delete(organization);
		
		return organization;
	}

}
