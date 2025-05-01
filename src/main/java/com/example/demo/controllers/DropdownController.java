package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.ifaces.CRUDCategoryService;

@Controller
public class DropdownController {

    @Autowired
    private CRUDCategoryService categoryService;

	@GetMapping("/racobeuPartneri") //https://localhost:8080/racobeu/racobeuPartneri     
    public String selectRacobeuPartneri(Model model) throws Exception {
		        model.addAttribute("partnersText");
        return "racobeuPartneri-info-page";
    }
	
	@GetMapping("/narvarre")     
    public String selectNarvarre(Model model) throws Exception {
		        model.addAttribute("Text");
        return "narvarre-page";
    }
	
	@GetMapping("/ventspils")     
    public String selectVentspils(Model model) throws Exception {
		        model.addAttribute("Text");
        return "ventspils-page";
    }
	
	@GetMapping("/adama")     
    public String selectAdama(Model model) throws Exception {
		        model.addAttribute("Text");
        return "adama-page";
    }
	
}