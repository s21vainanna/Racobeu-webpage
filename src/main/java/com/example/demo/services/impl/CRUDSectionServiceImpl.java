package com.example.demo.services.impl;

import java.sql.Date;
import java.util.ArrayList;

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

	@Override
	public ArrayList<Section> selectAllSection() {
		return (ArrayList<Section>) sectionRepository.findAll();
	}

	@Override
	public Section selectSectionById(int id) throws Exception {
		Section section = sectionRepository.findById(id).orElse(null);

		if (section == null) {
			throw new Exception("Section not found");
		}
		return section;
	}

	@Override
	public Section saveSection(Section section) {
		Section newSection = new Section();
		newSection.setSectionId(section.getSectionId());
		newSection.setCategory(section.getCategory());
		newSection.setImage(section.getImage());
		newSection.setShortIntro(section.getShortIntro());
		newSection.setText(section.getText());
		newSection.setTitle(section.getTitle());
		newSection.setAuthor(section.getAuthor());
		newSection.setCategory(section.getCategory());
		newSection.setCreatedDate(new Date(System.currentTimeMillis()));
		newSection.setYoutubeVideo(section.getYoutubeVideo());
		return sectionRepository.save(newSection);
	}

	@Override
	public void deleteSection(int id) throws Exception {
		if (!sectionRepository.existsById(id)) {
			throw new Exception("Section not found");
		}
		
		sectionRepository.deleteById(id);
	}
	
}
