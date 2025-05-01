package com.example.demo.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.ifaces.CRUDSectionService;
import com.example.demo.model.Section;
import com.example.demo.repo.SectionRepository;

@Service
public class CRUDSectionServiceImpl implements CRUDSectionService {

	@Autowired
	private SectionRepository sectionRepository;

	@Override
	public Section selectById(int id) throws Exception {
		Section section = sectionRepository.findById(id).orElse(null);
		
		if (section == null) {
			throw new Exception("Section not found");
		}

		return section;
	}
	
}
