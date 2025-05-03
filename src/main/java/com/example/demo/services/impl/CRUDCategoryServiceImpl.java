package com.example.demo.services.impl;

import java.util.ArrayList;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.LocaleResolver;

import com.example.demo.ifaces.CRUDCategoryService;
import com.example.demo.model.Category;
import com.example.demo.model.Language;
import com.example.demo.repo.CategoryRepository;

@Service
public class CRUDCategoryServiceImpl implements CRUDCategoryService {
	@Autowired
    private LocaleResolver localeResolver;

	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public ArrayList<Category> selectAllCategoryByCurrentLanguage() throws Exception{
		String userLanguage = getCurrentLanguage(); 
		if (userLanguage == null) {
			throw new Exception("No language selected");
		}
		return (ArrayList<Category>) categoryRepository.findAllByLanguageLanguageCode(userLanguage);
	}


	// nosaka patreizejo lietotaja valodu
	public String getCurrentLanguage() {
        Locale currentLocale = LocaleContextHolder.getLocale();
        return currentLocale.getLanguage();
        
    }


	@Override
	public ArrayList<Category> selectAllCategory() {
		return (ArrayList<Category>) categoryRepository.findAll();
	}
	@Override
	public Category selectCategoryById(int id) throws Exception {
		Category category = categoryRepository.findById(id).orElse(null);

		if (category == null) {
			throw new Exception("Category not found");
		}
		return category;
	}


	@Override
	public Category saveCategory(Category category) {
		Category newCategory = new Category();
		newCategory.setTitle(category.getTitle());
		newCategory.setLanguage(category.getLanguage());
		return categoryRepository.save(newCategory);

	}


	@Override
	public void deleteCategory(int id) throws Exception {
		if (!categoryRepository.existsById(id)) {
			throw new Exception("Category not found");
		}

		categoryRepository.deleteById(id);
	}

}
