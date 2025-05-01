package com.example.demo.ifaces;

import java.util.ArrayList;

import com.example.demo.model.Category;

public interface CRUDCategoryService {
	
	ArrayList<Category> selectAllCategory() throws Exception;

}
