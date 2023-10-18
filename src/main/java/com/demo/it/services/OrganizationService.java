package com.demo.it.services;

import java.util.List;

import com.demo.it.models.Organization;

public interface OrganizationService {
	
	Organization saveOrganization(Organization organization);
	
	Organization getOrganizationById(long organization_id);
	
	List<Organization> getAllOrganizations();
	
	Organization updateOrganization(Organization organization, long org_id);
	
	Organization deleteOrganization(long organization_id);
	
}
