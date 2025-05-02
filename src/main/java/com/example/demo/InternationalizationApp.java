package com.example.demo;
import java.sql.SQLIntegrityConstraintViolationException;

import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.services.impl.AdministratorDetailsService;

@SpringBootApplication
public class InternationalizationApp implements CommandLineRunner {

    @Autowired
    private AdministratorDetailsService administratorDetailsService;
    
    public static void main(String[] args) {
        SpringApplication.run(InternationalizationApp.class, args);
    }

    /* @Bean
     CommandLineRunner commandLineRunner(AdministratorDetailsService administratorDetailsService) {
         try {
             return args -> administratorDetailsService.createAdministrator("admin", "admin");
         } catch (SQLIntegrityConstraintViolationException e) {
             // admin lietotajs jau eksiste
             return null;
         }
     } */

    // katru reizi palaižot spring boot, izveido admin lietotāju
    @Override
    public void run(String... args) throws Exception {
        try {
            administratorDetailsService.createAdministrator("admin", "admin");
        } catch (Exception e) {
            // admin lietotajs jau eksiste
        }
    }

}
