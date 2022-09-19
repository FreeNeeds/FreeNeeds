package com.ssafy.backend.db.repository;

import com.ssafy.backend.db.entity.CompanyInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CompanyInfoRepository extends JpaRepository<CompanyInfo, Long> {

    @Query("from CompanyInfo c inner join fetch c.company where c.company.companyId = :companyId")
    Optional<CompanyInfo> findCompanyInfoByCompanyId(Long companyId);

    @Query("from CompanyInfo c inner join fetch c.company where c.company.username = :username")
    Optional<CompanyInfo> findCompanyInfoByCompanyUsername(String username);
}
