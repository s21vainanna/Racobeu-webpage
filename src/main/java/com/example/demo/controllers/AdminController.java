package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.ifaces.CRUDLanguageService;
import com.example.demo.model.Language;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@Controller
public class AdminController {

	@Autowired
	private CRUDLanguageService languageService;

	@GetMapping("/admin") // http://localhost:8080/admin
	public String adminTest() {
		return "admin/admin-homepage";
	}

	// LANGUAGE CRUD

	@GetMapping("/admin/languages") // http://localhost:8080/admin/languages
	public String adminCreateLanguages(Model model, @RequestParam(required = false) Integer id) throws Exception {
		if (id != null) {
			// labot esošu
			model.addAttribute("language", languageService.selectLanguageById(id));
			model.addAttribute("id", id);
		}
		else {
			// jauns
			model.addAttribute("language", new Language());
			model.addAttribute("id", 0);
		}


		model.addAttribute("languages", languageService.selectAllLanguage());
		return "admin/admin-language";
	}

	@PostMapping("/admin/languages/save")
	public String adminCreateUpdateLanguage(@Valid Language language, BindingResult result,
			@RequestParam(required = true) Integer id) throws Exception {
		// parbauda validacijas kludas
		if (result.hasErrors()) {
			return "admin/admin-language";
		}

		if (id == 0) {
			languageService.saveLanguage(language);
		} else {
			language.setLanguageId(id);
			languageService.saveLanguage(language);
		}

		return "redirect:/admin/languages";
	}

	@PostMapping("/admin/languages/delete")
	public String adminDeleteLanguage(@RequestParam(required = true) Integer id) throws Exception {
		try {
			Language language = languageService.selectLanguageById(id);
		} catch (Exception e) {
			return "redirect:/admin/languages";
		}

		languageService.deleteLanguage(id);
		return "redirect:/admin/languages";
	}
	
}
