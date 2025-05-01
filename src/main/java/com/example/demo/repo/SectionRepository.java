package com.example.demo.repo;

import org.springframework.data.convert.ReadingConverter;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Section;

@Repository
public interface SectionRepository extends CrudRepository<Section, Integer> {
	
}
