package com.demo.it.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.it.models.Organization;

public interface OrganizationRepository extends JpaRepository<Organization, Long> {

}
