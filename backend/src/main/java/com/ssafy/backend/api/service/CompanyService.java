package com.ssafy.backend.api.service;

import com.ssafy.backend.api.request.CompanyInfoPostReq;
import com.ssafy.backend.api.request.CompanyRegisterPostReq;
import com.ssafy.backend.db.entity.Company;
import com.ssafy.backend.db.entity.CompanyInfo;

import java.util.Map;
import java.util.Optional;

/**
 *	기업 관련 비즈니스 로직 처리를 위한 서비스 인터페이스 정의.
 */
public interface CompanyService {
    Company createCompany(CompanyRegisterPostReq registerInfo);

    void validateDuplicateMember(CompanyRegisterPostReq companyRegisterInfo);

    void validateDuplicateEmail(CompanyRegisterPostReq companyRegisterInfo);

    void validateDuplicateName(CompanyRegisterPostReq companyRegisterInfo);

    Optional<Company> getCompanyByUsername(String username);

    Optional<Company> getCompanyByEmail(String email);

    Optional<Company> getCompanyByName(String name);

    Optional<Company> getCompanyByCompanyId(Long companyId);

    CompanyInfo createCompanyInfo(Company company, CompanyInfoPostReq companyInfoPostReq);

    CompanyInfo updateCompanyInfo(Long companyId, Map<Object, Object> objectMap);

    Company updateCompany(Long companyId, Map<Object, Object> objectMap);

    Optional<CompanyInfo> getCompanyInfoByCompanyId(Long companyId);
}
