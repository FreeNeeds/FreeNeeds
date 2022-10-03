package com.ssafy.backend.db.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.ssafy.backend.db.entity.Company;
import com.ssafy.backend.db.entity.QCompany;
import com.ssafy.backend.db.entity.QUser;
import com.ssafy.backend.db.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * 기업 모델 관련 디비 쿼리 생성을 위한 구현 정의.
 */
@Repository
@RequiredArgsConstructor
public class CompanyRepositorySupport {
    private final JPAQueryFactory jpaQueryFactory;
    QCompany qCompany = QCompany.company;

    public Optional<Company> findCompanyByUsername(String username) {
        Company company = jpaQueryFactory.select(qCompany).from(qCompany)
                .where(qCompany.username.eq(username)).fetchOne();
        if(company == null) return Optional.empty();
        return Optional.ofNullable(company);
    }

    public String findCompanyAccountAddressByUsername(String username) {
        String accountAddress = jpaQueryFactory.select(qCompany.accountAddress).from(qCompany)
                .where(qCompany.username.eq(username)).fetchOne();
        return accountAddress;
    }

    public String findCompanyAccountAddressByCompanyId(Long companyId) {
        String accountAddress = jpaQueryFactory.select(qCompany.accountAddress).from(qCompany)
                .where(qCompany.companyId.eq(companyId)).fetchOne();
        return accountAddress;
    }
}
