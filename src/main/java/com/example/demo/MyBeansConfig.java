package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;

@Configuration
public class MyBeansConfig implements WebMvcConfigurer{
	@Bean
	public LocaleResolver localeResolver() {
		// valoda bus piesaistita lietotaja sesijai
	    SessionLocaleResolver slr = new SessionLocaleResolver();
		// noklusejuma valoda ja neviena valoda nav izveleeta
	    slr.setDefaultLocale(Locale.US);
	    return slr;
	}
	
	@Bean
	public LocaleChangeInterceptor localeChangeInterceptor() {
	    LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
		// saites parametrs, kurs uzstada valodu, piemeram, localhost/test?lang=lv 
	    lci.setParamName("lang");
	    return lci;
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
	    registry.addInterceptor(localeChangeInterceptor());
	}
	
}
