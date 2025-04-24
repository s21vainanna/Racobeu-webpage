package com.example.demo.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Scientific_Research;


@Repository
public interface Scientific_ResearchRepository extends CrudRepository<Scientific_Research, Integer>{

}
