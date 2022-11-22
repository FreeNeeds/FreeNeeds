package com.ssafy.backend.db.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.ssafy.backend.db.entity.Contract;
import com.ssafy.backend.db.entity.QContract;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

/**
 * 계약서 모델 관련 디비 쿼리 생성을 위한 구현 정의.
 */
@Repository
@RequiredArgsConstructor
public class ContractRepositorySupport {
    private final JPAQueryFactory jpaQueryFactory;
    private final QContract qContract = QContract.contract;

    public Contract findContractByUserIdAndProjectId(Long userId, Long projectId) {
        Contract contract = jpaQueryFactory.select(qContract).from(qContract)
                .where(qContract.user.userId.eq(userId),
                        qContract.project.projectId.eq(projectId))
                .fetchOne();

        return contract;
    }
}
