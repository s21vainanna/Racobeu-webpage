package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class AdminController {
	
	@GetMapping("/admin")
	public String adminTest() {
		return "admin/admin-homepage";
	}
	
}
