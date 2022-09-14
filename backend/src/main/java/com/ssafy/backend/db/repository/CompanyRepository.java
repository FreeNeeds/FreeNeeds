package com.ssafy.backend.db.repository;

import com.ssafy.backend.db.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {
}
