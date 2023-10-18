package com.demo.it.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.it.models.PersonalDetails;

public interface PersonalDetailsRepository extends JpaRepository<PersonalDetails, Long> {

}
