package com.example.demo.model;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

// spring security klase administratora informacijai
public class AdministratorDetails implements UserDetails {

	// administratora dati no datubazes
    private final Administrator admin;

    public AdministratorDetails(Administrator admin) {
        this.admin = admin;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
		// administratoram vienmer būs role admin
        return Collections.singleton(() -> "ROLE_ADMIN");
    }

	// paņem paroli no datubazes klases 
    @Override
    public String getPassword() {
        return admin.getPassword();
    }

	// paņem lietotaja vardu no datubazes klases
    @Override
    public String getUsername() {
        return admin.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public Administrator getAdministrator() {
        return admin;
    }
}