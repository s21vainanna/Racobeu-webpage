package com.example.demo.ifaces;

import java.util.ArrayList;

import com.example.demo.model.Language;

public interface CRUDLanguageService {
	
	ArrayList<Language> selectAllLanguage();

	Language selectLanguageById(int id) throws Exception;

	Language saveLanguage(Language language);

	void deleteLanguage(int id) throws Exception;

}
