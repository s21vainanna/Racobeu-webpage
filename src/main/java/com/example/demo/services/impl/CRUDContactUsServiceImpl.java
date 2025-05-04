package com.example.demo.services.impl;

import java.sql.Date;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.ifaces.CRUDContactUsService;
import com.example.demo.model.ContactUs;
import com.example.demo.repo.ContactUsRepository;

@Service
public class CRUDContactUsServiceImpl implements CRUDContactUsService{
	
	@Autowired
	private ContactUsRepository contactUsRepository;

	@Override
	public ContactUs saveContactUs(ContactUs contactUs) {
		ContactUs newContactUs = new ContactUs();
		newContactUs.setName(contactUs.getName());
		newContactUs.setEmail(contactUs.getEmail());
		newContactUs.setMessage(contactUs.getMessage());
		newContactUs.setSavedDate(new Date(System.currentTimeMillis()));
		return contactUsRepository.save(newContactUs);
	}

	@Override
	public void deleteContactUs(int id) throws Exception {
		if (!contactUsRepository.existsById(id)) {
			throw new Exception("ContactUs not found");
		}
		
		contactUsRepository.deleteById(id);
	}

	@Override
	public ArrayList<ContactUs> selectAllContactUs() {
		return (ArrayList<ContactUs>) contactUsRepository.findAll();
	}

	@Override
	public ContactUs selectContactUsById(int id) throws Exception {
		ContactUs contactUs = contactUsRepository.findById(id).orElse(null);

		if (contactUs == null) {
			throw new Exception("ContactUs not found");
		}
		return contactUs;
	}

}
