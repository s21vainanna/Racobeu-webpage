package com.example.demo.repo;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Events;

public interface EventsRepository extends CrudRepository<Events, Integer>{

}
