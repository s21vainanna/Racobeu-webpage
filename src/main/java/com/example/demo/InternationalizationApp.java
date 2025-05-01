package com.example.demo;
import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InternationalizationApp {
    
    public static void main(String[] args) {
        SpringApplication.run(InternationalizationApp.class, args);
    }

}
