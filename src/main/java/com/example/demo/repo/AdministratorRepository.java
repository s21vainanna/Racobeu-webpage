package com.example.demo.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Administrator;

@Repository
public interface AdministratorRepository extends CrudRepository<Administrator, Integer> {

	// atrod administratoru pec lietotaja varda
	// SELECT * FROM administrator WHERE username = ?
	// Administrator.username
	Administrator findByUsername(String username);

}
