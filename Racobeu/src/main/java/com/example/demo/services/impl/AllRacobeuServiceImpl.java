package com.example.demo.services.impl;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.ifaces.IDepartments;
import com.example.demo.ifaces.IEvents;
import com.example.demo.ifaces.IRacobeu;
import com.example.demo.ifaces.IRadioAstronomy_Institutions;
import com.example.demo.ifaces.IRadioteleskopi;
import com.example.demo.model.Departments;
import com.example.demo.model.Events;
import com.example.demo.model.Racobeu;
import com.example.demo.model.RadioAstronomy_Institutions;
import com.example.demo.model.Radioteleskopi;
import com.example.demo.repo.DepartmentsRepository;
import com.example.demo.repo.EventsRepository;
import com.example.demo.repo.RacobeuRepository;
import com.example.demo.repo.RadioAstronomy_InstitutionsRepository;
import com.example.demo.repo.RadioteleskopiRepository;

@Service
public class AllRacobeuServiceImpl implements IRacobeu, IRadioteleskopi, IRadioAstronomy_Institutions, 
IEvents, IDepartments{
	
	@Autowired
	private RacobeuRepository racobeuRepository;
	
	@Autowired
	private RadioteleskopiRepository radioteleskopiRepository;
	
	@Autowired
	private RadioAstronomy_InstitutionsRepository radioAstronomy_Institutions;
	
	@Autowired
	private EventsRepository eventsRepository;
	
	@Autowired
	private DepartmentsRepository departmentsRepository; 
	
	
	ArrayList<Racobeu> racobeuList = new ArrayList<>();
	ArrayList<Radioteleskopi> radioteleskopiList = new ArrayList<>();
	ArrayList<RadioAstronomy_Institutions> radioAstronomy_InstitutionsList = new ArrayList<>();
	ArrayList<Events> eventsList = new ArrayList<>();
	ArrayList<Departments> departmentsList = new ArrayList<>();
	
	
	@Override
	public ArrayList<Racobeu> selectAll() throws Exception {
		if(racobeuRepository.count()==0) {
			throw new Exception("List is empty.");
		}
		return (ArrayList<Racobeu>) racobeuRepository.findAll();
	}

	@Override
	public ArrayList<Radioteleskopi> select() throws Exception {
		if(radioteleskopiRepository.count()==0) {
			throw new Exception("List is empty.");
		}
		return (ArrayList<Radioteleskopi>) radioteleskopiRepository.findAll();
	}

	@Override
	public ArrayList<RadioAstronomy_Institutions> sel() throws Exception {
		if(radioAstronomy_Institutions.count()==0) {
			throw new Exception("List is empty.");
		}
		return (ArrayList<RadioAstronomy_Institutions>) radioAstronomy_Institutions.findAll();
	}

	@Override
	public ArrayList<Events> selectall() throws Exception {
		if(eventsRepository.count()==0) {
			throw new Exception("List is empty.");
		}
		return (ArrayList<Events>) eventsRepository.findAll();
	}

	@Override
	public ArrayList<Departments> selectedAll() throws Exception {
		if(departmentsRepository.count()==0) {
			throw new Exception("List is empty.");
		}
		return (ArrayList<Departments>) departmentsRepository.findAll();
	}
	
	

}
