package com.example.demo.ifaces;

import com.example.demo.model.Section;

public interface CRUDSectionService {
	
	Section selectById(int id) throws Exception;

}
