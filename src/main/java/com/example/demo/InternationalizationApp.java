package com.example.demo;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.logging.Logger;

import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.javapoet.ClassName;

import com.example.demo.model.Administrator;
import com.example.demo.services.impl.AdministratorDetailsService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
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

    // katru reizi palaižot spring boot, izveido noklusējuma admin lietotāju
    @Override
    public void run(String... args) throws Exception {
        try {
            Administrator admin = new Administrator();
            admin.setUsername("admin");
            admin.setPassword("admin");
            administratorDetailsService.saveAdministrator(admin);
            log.info("Administrator account created! Username: admin, Password: admin");
            log.info("!!! Please change password after first login !!!");
        } catch (Exception e) {
            log.info("Administrator account \"admin\" already exists.");
            // admin lietotajs jau eksiste
        }
    }

}
