package com.ssafy.backend.api.service;

import com.ssafy.backend.api.request.CompanyRegisterPostReq;
import com.ssafy.backend.db.entity.Company;
import com.ssafy.backend.db.entity.User;
import com.ssafy.backend.db.repository.CompanyRepository;
import com.ssafy.backend.db.repository.CompanyRepositorySupport;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 *	기업 관련 비즈니스 로직 처리를 위한 서비스 구현 정의.
 */
@Service("companyService")
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService{

    private final CompanyRepository companyRepository;

    private final CompanyRepositorySupport companyRepositorySupport;

    private final PasswordEncoder passwordEncoder;

    @Override
    public Company createCompany(CompanyRegisterPostReq companyRegisterInfo) {
        //중복 확인
        validateDuplicateMember(companyRegisterInfo);

        Company company = new Company();
        company.setUsername(companyRegisterInfo.getUsername());
        // 보안을 위해서 유저 패스워드 암호화 하여 디비에 저장.
        company.setPassword(passwordEncoder.encode(companyRegisterInfo.getPassword()));
        company.setEmail(companyRegisterInfo.getEmail());
        company.setName(companyRegisterInfo.getName());
        company.setPhone(companyRegisterInfo.getPhone());

        return companyRepository.save(company);
    }

    @Override
    public void validateDuplicateMember(CompanyRegisterPostReq companyRegisterInfo) {
        if (getCompanyByUsername(companyRegisterInfo.getUsername()).orElse(null) != null) {
            throw new IllegalStateException("Please enter a different username.");
        }
    }

    @Override
    public Optional<Company> getCompanyByUsername(String username) {
        // 디비에 유저 정보 조회 (userId 를 통한 조회).
        Optional<Company> company = companyRepositorySupport.findCompanyByUsername(username);
        return company;
    }
}
