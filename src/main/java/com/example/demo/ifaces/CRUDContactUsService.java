package com.example.demo.ifaces;

import java.util.ArrayList;

import com.example.demo.model.ContactUs;
import com.example.demo.model.Language;

public interface CRUDContactUsService {

	ArrayList<ContactUs> selectAllContactUs();

	ContactUs selectContactUsById(int id) throws Exception;
	
	ContactUs saveContactUs(ContactUs contactUs);
	
	void deleteContactUs(int id) throws Exception;

}
