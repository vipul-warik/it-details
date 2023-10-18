package com.demo.it.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PersonalDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long personalId;
	
	private String gender;
	
	private String bithDate;
	
	private String mobileNo;
	
    private String bloodGroup;
    
    private String address;
    
    @JsonBackReference
    @OneToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;
    
    
}
