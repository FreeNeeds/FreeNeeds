package com.ssafy.backend.db.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.ssafy.backend.db.entity.Domain;
import com.ssafy.backend.db.entity.Project;
import com.ssafy.backend.db.entity.QDomain;
import com.ssafy.backend.db.entity.QProject;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public class DomainRepositorySupport extends QuerydslRepositorySupport {
    private final JPAQueryFactory jpaQueryFactory;

    QDomain qDomain = QDomain.domain;

    public DomainRepositorySupport(JPAQueryFactory jpaQueryFactory) {
        super(Domain.class);
        this.jpaQueryFactory = jpaQueryFactory;
    }

    public List<Domain> findDomainByName(String domainName){
        List<Domain> domainList =jpaQueryFactory.selectFrom(qDomain)
                .where(qDomain.domainName.eq(domainName))
                .fetch();
        return domainList;
    }
}
