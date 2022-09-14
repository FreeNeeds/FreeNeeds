package com.ssafy.backend.api.service;

import com.ssafy.backend.api.request.CompanyRegisterPostReq;
import com.ssafy.backend.api.request.UserRegisterPostReq;
import com.ssafy.backend.db.entity.Company;
import com.ssafy.backend.db.entity.User;

import java.util.Optional;

/**
 *	기업 관련 비즈니스 로직 처리를 위한 서비스 인터페이스 정의.
 */
public interface CompanyService {
    Company createCompany(CompanyRegisterPostReq registerInfo);

    void validateDuplicateMember(CompanyRegisterPostReq companyRegisterInfo);

    Optional<Company> getCompanyByUsername(String username);
}
