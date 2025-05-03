package com.example.demo.ifaces;

import java.util.ArrayList;

import com.example.demo.model.Language;
import com.example.demo.model.Section;

public interface CRUDSectionService {
	
	Section selectById(int id) throws Exception;

	ArrayList<Section> selectAllSection();

	Section selectSectionById(int id) throws Exception;

	Section saveSection(Section section);

	void deleteSection(int id) throws Exception;

}
