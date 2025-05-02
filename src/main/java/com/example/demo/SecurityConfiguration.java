package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {

	/*  https://spring.io/guides/gs/securing-web

	https://www.geeksforgeeks.org/spring-security-logout/ */
	
	@Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
			// PIEKĻUVE LAPĀM
            .authorizeHttpRequests(auth -> auth
				// visas saites kuras sākas ar /admin ir pieejamas tikai ar admin role
                .requestMatchers("/admin/**").hasRole("ADMIN")
				// visu pārējo atļauj piekļūt visiem apmeklētajiem
                .anyRequest().permitAll()
            )

			// LOGIN
            .formLogin(form -> form
				// pēc veiksmīgas autorizācijas novirzīt uz /admin
				.defaultSuccessUrl("/admin")
				// visi var redzet /login lapu
                .permitAll()
            )

			// LOGOUT
            .logout(logout -> logout
				// /logout lapa
				.logoutUrl("/logout")
				// pēc logout novirzīt uz /
				.logoutSuccessUrl("/")
				// ikviens var izmantot /logout lapu
				.permitAll());
        return http.build();
    }


/* 	@Bean
    public UserDetailsService userDetailsService(PasswordEncoder encoder) {
        return new InMemoryUserDetailsManager(
            User.withUsername("admin")
                .password(encoder.encode("password"))
                .roles("ADMIN")
                .build()
        );
    }
*/
	// definē paroļu pārveidotāju
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
