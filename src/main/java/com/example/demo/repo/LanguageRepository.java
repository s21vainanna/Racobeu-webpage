package com.example.demo.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Language;

@Repository
public interface LanguageRepository extends CrudRepository<Language, Integer> {
	
}
