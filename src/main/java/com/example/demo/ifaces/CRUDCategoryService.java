package com.example.demo.ifaces;

import java.util.ArrayList;

import com.example.demo.model.Category;
import com.example.demo.model.Language;

public interface CRUDCategoryService {
	
	ArrayList<Category> selectAllCategoryByCurrentLanguage() throws Exception;

	ArrayList<Category> selectAllCategory();

	Category selectCategoryById(int id) throws Exception;

	Category saveCategory(Category category);

	void deleteCategory(int id) throws Exception;

}
