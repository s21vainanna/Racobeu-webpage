package com.example.demo.controllers;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.LocaleResolver;

import com.example.demo.ifaces.CRUDCategoryService;

@Controller
public class HomeController {

    @Autowired
    private CRUDCategoryService categoryService;

	@GetMapping("/")
    public String greet(Model model) throws Exception{
        model.addAttribute("categories", categoryService.selectAllCategoryByCurrentLanguage());
        return "main-page";
    }

}
