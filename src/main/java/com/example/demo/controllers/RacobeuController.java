package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.services.impl.AllRacobeuServiceImpl;

@Controller
@RequestMapping("/racobeu")
public class RacobeuController {
	
	@Autowired
	private AllRacobeuServiceImpl racobeuService;
	
	@GetMapping("/selectRacobeu") //https://localhost:8080/racobeu/selectRacobeu       Fetches data(from productList) using a service, Adds data to the Model object, the view for example Thymeleaf accesses the data stored in the model
    public String selectRacobeu(Model model) throws Exception {
        model.addAttribute("racobeuList", racobeuService.selectAll());
        return "about-us-page";
    }
	
	@GetMapping("/News") //https://localhost:8080/racobeu/selectRacobeu       Fetches data(from productList) using a service, Adds data to the Model object, the view for example Thymeleaf accesses the data stored in the model
    public String selectNews(Model model) throws Exception {
        model.addAttribute("racobeuList", racobeuService.selectAll());
        return "racobeu-news-page";
    }
	
	@GetMapping("/racobeuAboutUs") //https://localhost:8080/racobeu/racobeuAboutUs     
    public String selectInfoAbousUs(Model model) throws Exception {
		        model.addAttribute("About-UsText");
        return "about-us-page";
    }
	
	@GetMapping("/selectRadioteleskopi") //https://localhost:8080/racobeu/selectRadioteleskopi      
    public String selectRadioteleskopi(Model model) throws Exception {
        model.addAttribute("radioteleskopiList", racobeuService.select());
        return "radioteleskopi-info-page";
    }
	
	@GetMapping("/selectInstitutions") //https://localhost:8080/racobeu/selectInstitutions       
    public String selectInstitutions(Model model) throws Exception {
        model.addAttribute("radioAstronomy_InstitutionsList", racobeuService.sel());
        return "radioAstronomy_Institutions-info-page";
    }
	

	@GetMapping("/selectDepartments") //https://localhost:8080/racobeu/selectDepartments      
    public String selectDepartments(Model model) throws Exception {
        model.addAttribute("departmentsList", racobeuService.selectedAll());
        return "departments-info-page";
    }
	
	
	@GetMapping("/selectEvents") //https://localhost:8080/racobeu/selectEvents       
    public String selectEvents(Model model) throws Exception {
        model.addAttribute("eventsList", racobeuService.selectall());
        return "events-info-page";
    }
	
}
