package com.example.demo.controllers;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.LocaleResolver;

import com.example.demo.ifaces.CRUDCategoryService;
import com.example.demo.ifaces.CRUDContactUsService;
import com.example.demo.model.ContactUs;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class HomeController {

    @Autowired
    private CRUDCategoryService categoryService;
    @Autowired
    private CRUDContactUsService contactUsService;

	@GetMapping("/")
    public String greet(Model model) throws Exception{
        model.addAttribute("categories", categoryService.selectAllCategoryByCurrentLanguage());
        return "main-page";
    }

    @GetMapping("contact-us")
    public String contactUsPage(Model model, @RequestParam(required = false) boolean success) throws Exception{
        model.addAttribute("success", success);
        model.addAttribute("id", 0);
        model.addAttribute("categories", categoryService.selectAllCategoryByCurrentLanguage());
        model.addAttribute("contactUs", new ContactUs());
        return "contact-us";
    }

    @PostMapping("/contact-us/save")
    public String saveContactUs(@Valid ContactUs contactUs, BindingResult result,
            @RequestParam(required = true) Integer id, Model model) throws Exception {
        // parbauda validacijas kludas
        if (result.hasErrors()) {
            // japievieno tos pašus atribūtus, kurus GET metodē, lai mainīgie būtu inicializēti
            model.addAttribute("id", id);
            model.addAttribute("contactUs", contactUs);
            model.addAttribute("categories", categoryService.selectAllCategoryByCurrentLanguage());
            return "contact-us";
        }

        contactUsService.saveContactUs(contactUs);
        return "redirect:/contact-us?success=true";
    }

}
