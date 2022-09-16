package com.ssafy.backend.common.auth;

import com.ssafy.backend.api.service.CompanyService;
import com.ssafy.backend.db.entity.Company;
import com.ssafy.backend.db.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SsafyCompanyDetailService implements UserDetailsService {

    private final CompanyService companyService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Company company = companyService.getCompanyByUsername(username).get();
        if(company != null) {
            SsafyCompanyDetails companyDetails = new SsafyCompanyDetails(company);
            return companyDetails;
        }
        return null;
    }

}