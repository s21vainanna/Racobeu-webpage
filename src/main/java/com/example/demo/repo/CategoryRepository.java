package com.example.demo.repo;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Integer> {
	
	// atrod visas kategorijas pec valodas koda
	// SELECT * FROM category WHERE language_id = ?
	// Category.Language.languageCode
	ArrayList<Category> findAllByLanguageLanguageCode(String languageCode);

}
