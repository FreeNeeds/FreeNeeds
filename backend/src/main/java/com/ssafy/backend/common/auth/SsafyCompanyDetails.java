package com.ssafy.backend.common.auth;

import com.ssafy.backend.db.entity.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class SsafyCompanyDetails implements UserDetails {

    @Autowired
    Company company;
    boolean accountNonExpired;
    boolean accountNonLocked;
    boolean credentialNonExpired;
    boolean enabled = false;
    List<GrantedAuthority> roles = new ArrayList<>();

    public SsafyCompanyDetails(Company company) {
        super();
        this.company = company;
    }

    public Company getCompany() {
        return this.company;
    }
    @Override
    public String getPassword() {
        return this.company.getPassword();
    }
    @Override
    public String getUsername() {
        return this.company.getUsername();
    }
    @Override
    public boolean isAccountNonExpired() {
        return this.accountNonExpired;
    }
    @Override
    public boolean isAccountNonLocked() {
        return this.accountNonLocked;
    }
    @Override
    public boolean isCredentialsNonExpired() {
        return this.credentialNonExpired;
    }
    @Override
    public boolean isEnabled() {
        return this.enabled;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.roles;
    }
    public void setAuthorities(List<GrantedAuthority> roles) {
        this.roles = roles;
    }
}
