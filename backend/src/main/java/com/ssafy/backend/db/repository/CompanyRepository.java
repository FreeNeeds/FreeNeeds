package com.ssafy.backend.db.repository;

import com.ssafy.backend.db.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CompanyRepository extends JpaRepository<Company, Long> {
    Optional<Company> findCompanyByEmail(String email);

    Optional<Company> findCompanyByName(String name);

    Optional<Company> findCompanyByUsername(String username);

    Company findCompanyByCompanyId(Long companyId);
}