package com.example.demo.controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.ifaces.CRUDCategoryService;
import com.example.demo.ifaces.CRUDContactUsService;
import com.example.demo.ifaces.CRUDLanguageService;
import com.example.demo.ifaces.CRUDNewsService;
import com.example.demo.ifaces.CRUDSectionService;
import com.example.demo.model.Administrator;
import com.example.demo.model.AdministratorDetails;
import com.example.demo.model.Category;
import com.example.demo.model.ContactUs;
import com.example.demo.model.Language;
import com.example.demo.model.NewsArticle;
import com.example.demo.model.Section;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@Controller
public class AdminController {

	@Autowired
	private CRUDLanguageService languageService;
	@Autowired
	private CRUDCategoryService categoryService;
	@Autowired
	private CRUDSectionService sectionService;
	@Autowired
	private CRUDNewsService newsArticleService;
	@Autowired
	private CRUDContactUsService contactUsService;

	@GetMapping("/admin") // http://localhost:8080/admin
	public String adminTest() {
		return "admin/admin-homepage";
	}

	// LANGUAGE CRUD

	@GetMapping("/admin/languages") // http://localhost:8080/admin/languages
	public String adminCreateLanguages(Model model, @RequestParam(required = false) Integer id) throws Exception {
		if (id != null && id != 0) {
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
			@RequestParam(required = true) Integer id, Model model) throws Exception {
		// parbauda validacijas kludas
		if (result.hasErrors()) {
			// japievieno tos pašus atribūtus, kurus GET metodē, lai mainīgie būtu inicializēti
			model.addAttribute("id", id);
			model.addAttribute("language", language);
			model.addAttribute("languages", languageService.selectAllLanguage());
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
	
	// CATEGORY CRUD

	@GetMapping("/admin/categories") // http://localhost:8080/admin/categories
	public String adminCreateCategories(Model model, @RequestParam(required = false) Integer id) throws Exception {
		if (id != null && id != 0) {
			// labot esošu
			model.addAttribute("category", categoryService.selectCategoryById(id));
			model.addAttribute("id", id);
		}
		else {
			// jauns
			model.addAttribute("category", new Category());
			model.addAttribute("id", 0);
		}


		model.addAttribute("categories", categoryService.selectAllCategory());
		model.addAttribute("languages", languageService.selectAllLanguage());
		return "admin/admin-category";
	}

	@PostMapping("/admin/categories/save")
	public String adminCreateUpdateCategory(@Valid Category category, BindingResult result,
			@RequestParam(required = true) Integer id, Model model) throws Exception {
		// parbauda validacijas kludas
		if (result.hasErrors()) {
			// japievieno tos pašus atribūtus, kurus GET metodē, lai mainīgie būtu inicializēti
			model.addAttribute("id", id);
			model.addAttribute("category", category);
			model.addAttribute("categories", categoryService.selectAllCategory());
			model.addAttribute("languages", languageService.selectAllLanguage());
			return "admin/admin-category";
		}

		if (id == 0) {
			categoryService.saveCategory(category);
		} else {
			category.setCategoryId(id);
			categoryService.saveCategory(category);
		}

		return "redirect:/admin/categories";
	}

	@PostMapping("/admin/categories/delete")
	public String adminDeleteCategory(@RequestParam(required = true) Integer id) throws Exception {
		try {
			Category category = categoryService.selectCategoryById(id);
		} catch (Exception e) {
			return "redirect:/admin/categories";
		}

		categoryService.deleteCategory(id);
		return "redirect:/admin/categories";
	}

	// SECTION CRUD

	@GetMapping("/admin/sections") // http://localhost:8080/admin/sections
	public String adminCreateSections(Model model, @RequestParam(required = false) Integer id) throws Exception {
		if (id != null && id != 0) {
			// labot esošu
			model.addAttribute("section", sectionService.selectSectionById(id));
			model.addAttribute("id", id);
		}
		else {
			// jauns
			model.addAttribute("section", new Section());
			model.addAttribute("id", 0);
		}

		model.addAttribute("sections", sectionService.selectAllSection());
		model.addAttribute("categories", categoryService.selectAllCategory());
		return "admin/admin-section";
	}

	@PostMapping("/admin/sections/save")
	public String adminCreateUpdatesSections(@Valid Section section, BindingResult result,
			@RequestParam(required = true) Integer id, Model model,
			@RequestParam(name = "upload-image", required = false) MultipartFile file) throws Exception {
		// parbauda validacijas kludas
		if (result.hasErrors()) {
			System.out.println(result);
			// japievieno tos pašus atribūtus, kurus GET metodē, lai mainīgie būtu inicializēti
			model.addAttribute("id", id);
			model.addAttribute("section", section);
			model.addAttribute("sections", sectionService.selectAllSection());
			model.addAttribute("categories", categoryService.selectAllCategory());
			return "admin/admin-section";
		}

		// nolasa MultipartFile attēlu kā byte[], jo datubāzē glabā byte[]
		if (!file.isEmpty()) {
			try {
				section.setImage(file.getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		// uzstāda lietotāju, kurš saglabāja datubāzē
		AdministratorDetails administratorDetails = (AdministratorDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		section.setAuthor(administratorDetails.getAdministrator());

		if (id == 0) {
			sectionService.saveSection(section);
		} else {
			section.setSectionId(id);
			sectionService.saveSection(section);
		}

		return "redirect:/admin/sections";
	}

	@PostMapping("/admin/sections/delete")
	public String adminDeleteSection(@RequestParam(required = true) Integer id) throws Exception {
		try {
			Section section = sectionService.selectSectionById(id);
		} catch (Exception e) {
			return "redirect:/admin/sections";
		}

		sectionService.deleteSection(id);
		return "redirect:/admin/sections";
	}

	// NEWS CRUD

	@GetMapping("/admin/news") // http://localhost:8080/admin/news
	public String adminCreateNews(Model model, @RequestParam(required = false) Integer id) throws Exception {
		if (id != null && id != 0) {
			// labot esošu
			model.addAttribute("newsArticle", newsArticleService.selectById(id));
			model.addAttribute("id", id);
		}
		else {
			// jauns
			model.addAttribute("newsArticle", new NewsArticle());
			model.addAttribute("id", 0);
		}

		model.addAttribute("newsArticles", newsArticleService.selectAllNewsArticle());
		model.addAttribute("languages", languageService.selectAllLanguage());
		return "admin/admin-news";
	}

	@PostMapping("/admin/news/save")
	public String adminCreateUpdatesNews(@Valid NewsArticle newsArticle, BindingResult result,
			@RequestParam(required = true) Integer id, Model model,
			@RequestParam(name = "upload-image", required = false) MultipartFile file) throws Exception {
		// parbauda validacijas kludas
		if (result.hasErrors()) {
			// japievieno tos pašus atribūtus, kurus GET metodē, lai mainīgie būtu inicializēti
			model.addAttribute("id", id);
			model.addAttribute("newsArticle", newsArticle);
			model.addAttribute("newsArticles", newsArticleService.selectAllNewsArticle());
			model.addAttribute("languages", languageService.selectAllLanguage());
			return "admin/admin-news";
		}

		// nolasa MultipartFile attēlu kā byte[], jo datubāzē glabā byte[]
		if (!file.isEmpty()) {
			try {
				newsArticle.setImage(file.getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		// uzstāda lietotāju, kurš saglabāja datubāzē
		AdministratorDetails administratorDetails = (AdministratorDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		newsArticle.setAuthor(administratorDetails.getAdministrator());

		if (id == 0) {
			newsArticleService.saveNewsArticle(newsArticle);
		} else {
			newsArticle.setNewsArticleId(id);
			newsArticleService.saveNewsArticle(newsArticle);
		}

		return "redirect:/admin/news";
	}

	@PostMapping("/admin/news/delete")
	public String adminDeleteNews(@RequestParam(required = true) Integer id) throws Exception {
		try {
			NewsArticle newsArticle = newsArticleService.selectById(id);
		} catch (Exception e) {
			return "redirect:/admin/news";
		}

		newsArticleService.deleteNewsArticle(id);
		return "redirect:/admin/news";
	}

	// CONTACT US CRUD

	@GetMapping("/admin/contact-us") // http://localhost:8080/admin/contact-us
	public String adminGetContactUs(Model model, @RequestParam(required = false) Integer id) throws Exception {
		if (id != null && id != 0) {
			// labot esošu
			model.addAttribute("message", contactUsService.selectContactUsById(id));
			model.addAttribute("id", id);
		}
		else {
			// jauns
			model.addAttribute("message", new ContactUs());
			model.addAttribute("id", 0);
		}

		model.addAttribute("messages", contactUsService.selectAllContactUs());
		return "admin/admin-contact-us";
	}

	@PostMapping("/admin/contact-us/delete")
	public String adminDeleteContactus(@RequestParam(required = true) Integer id) throws Exception {
		try {
			ContactUs contactUs = contactUsService.selectContactUsById(id);
		} catch (Exception e) {
			return "redirect:/admin/contact-us";
		}

		contactUsService.deleteContactUs(id);
		return "redirect:/admin/contact-us";
	}

}
