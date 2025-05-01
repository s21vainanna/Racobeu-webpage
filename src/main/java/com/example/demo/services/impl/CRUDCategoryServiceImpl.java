package com.example.demo.services.impl;

import java.util.ArrayList;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.LocaleResolver;

import com.example.demo.ifaces.CRUDCategoryService;
import com.example.demo.model.Category;
import com.example.demo.repo.CategoryRepository;

@Service
public class CRUDCategoryServiceImpl implements CRUDCategoryService {
	@Autowired
    private LocaleResolver localeResolver;

	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public ArrayList<Category> selectAllCategory() {
		String userLanguage = getCurrentLanguage(); 
		return (ArrayList<Category>) categoryRepository.findAllByLanguageLanguageCode(userLanguage);
	}


	// nosaka patreizejo lietotaja valodu
	public String getCurrentLanguage() {
        Locale currentLocale = LocaleContextHolder.getLocale();
        return currentLocale.getLanguage();
        
    }
}
