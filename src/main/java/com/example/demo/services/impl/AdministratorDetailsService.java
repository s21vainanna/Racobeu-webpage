package com.example.demo.services.impl;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.model.Administrator;
import com.example.demo.model.AdministratorDetails;
import com.example.demo.repo.AdministratorRepository;


/*
  Šī klase atļauj izmantot spring security administratora datus
  no datubazes.   
 */
@Service
public class AdministratorDetailsService implements UserDetailsService {

	@Autowired
	private PasswordEncoder passwordEncoder;

    private final AdministratorRepository repository;

    public AdministratorDetailsService(AdministratorRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// atrod administratoru pec lietotaja varda
        Administrator admin = repository.findByUsername(username);

		// ja nav atrasts, izmest exception
		if (admin == null) {
			throw new UsernameNotFoundException("Username not found!");
		}

		// atgriež spring security administratora klasi ar administratora informaciju no db
        return new AdministratorDetails(admin);
    }

	public Administrator createAdministrator(String username, String password) {
		Administrator newAdministrator = new Administrator();
		newAdministrator.setUsername(username);

		// !!! nesaglabā paroli tā kā tā ievadīta, bet
		// pārvēršam paroli uz paroles hash vertībū
		String passwordHash = passwordEncoder.encode(password);
		newAdministrator.setPassword(passwordHash);
		newAdministrator.setRegistationDate(new Date(System.currentTimeMillis()));

		// saglabat datubaze
		return repository.save(newAdministrator);
	}

}
