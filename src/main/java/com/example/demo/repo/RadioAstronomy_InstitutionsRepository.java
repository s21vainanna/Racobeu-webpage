package com.example.demo.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.RadioAstronomy_Institutions;

@Repository
public interface RadioAstronomy_InstitutionsRepository extends CrudRepository<RadioAstronomy_Institutions, Integer>{

}
