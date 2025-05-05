package com.example.demo.services.impl;

import java.sql.Date;
import java.util.ArrayList;

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

	public Administrator saveAdministrator(Administrator admin) {
		Administrator newAdministrator = new Administrator();
		newAdministrator.setId(admin.getId());
		newAdministrator.setUsername(admin.getUsername());

		// !!! nesaglabā paroli tā kā tā ievadīta, bet
		// pārvēršam paroli uz paroles hash vertībū
		String passwordHash = passwordEncoder.encode(admin.getPassword());
		newAdministrator.setPassword(passwordHash);
		newAdministrator.setRegistationDate(new Date(System.currentTimeMillis()));

		// saglabat datubaze
		return repository.save(newAdministrator);
	}

	public ArrayList<Administrator> selectAllAdministrator() {
		return (ArrayList<Administrator>) repository.findAll();
	}

	public Administrator selectAdministratorById(int id) throws Exception {
		Administrator admin = repository.findById(id).orElse(null);

		if (admin == null) {
			throw new Exception("Administrator not found");
		}
		return admin;
	}

	public void deleteAdministrator(int id) throws Exception {
		if (!repository.existsById(id)) {
			throw new Exception("Administrator not found");
		}
		repository.deleteById(id);
	}

}
