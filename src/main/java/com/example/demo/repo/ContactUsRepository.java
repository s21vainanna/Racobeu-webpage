package com.example.demo.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.ContactUs;

@Repository
public interface ContactUsRepository extends CrudRepository<ContactUs, Integer> {
	
}
