package com.example.demo.services.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.ifaces.CRUDLanguageService;
import com.example.demo.model.Language;
import com.example.demo.repo.LanguageRepository;

@Service
public class CRUDLanguageServiceImpl implements CRUDLanguageService {
	
	@Autowired
	private LanguageRepository	languageRepository;

	@Override
	public ArrayList<Language> selectAllLanguage() {
		return (ArrayList<Language>) languageRepository.findAll();
	}

	@Override
	public Language selectLanguageById(int id) throws Exception {
		Language lang = languageRepository.findById(id).get();

		if (lang == null) {
			throw new Exception("Language not found");
		}
		return lang;
	}

	@Override
	public Language saveLanguage(Language language) {
		Language newLanguage = new Language();
		newLanguage.setLanguageId(language.getLanguageId());
		newLanguage.setName(language.getName());
		newLanguage.setLanguageCode(language.getLanguageCode());
		return languageRepository.save(newLanguage);
	}

	@Override
	public void deleteLanguage(int id) throws Exception {
		if (!languageRepository.existsById(id)) {
			throw new Exception("Language not found");
		}

		languageRepository.deleteById(id);
	}

	
}
