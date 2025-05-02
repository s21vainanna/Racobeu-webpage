package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.ifaces.CRUDCategoryService;
import com.example.demo.ifaces.CRUDSectionService;

import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class DropdownController {

    @Autowired
    private CRUDCategoryService categoryService;
    @Autowired
    private CRUDSectionService sectionService;

    @GetMapping("/section/{sectionId}") // http://localhost:8080/section/1
    public String selectSection(@PathVariable("sectionId") int sectionId, Model model) throws Exception {
        model.addAttribute("categories", categoryService.selectAllCategoryByCurrentLanguage());
        model.addAttribute("section", sectionService.selectById(sectionId));
        return "section-page";
    }


}