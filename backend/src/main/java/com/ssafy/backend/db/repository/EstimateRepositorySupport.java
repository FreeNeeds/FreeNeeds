package com.ssafy.backend.db.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.ssafy.backend.db.entity.Estimate;
import com.ssafy.backend.db.entity.QEstimate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 평점 모델 관련 디비 쿼리 생성을 위한 구현 정의.
 */
@Repository
@RequiredArgsConstructor
public class EstimateRepositorySupport {
    private final JPAQueryFactory jpaQueryFactory;
    QEstimate qEstimate = QEstimate.estimate;

    public List<Estimate> findAllByUsername(String username) {
        List<Estimate> estimateList = jpaQueryFactory.select(qEstimate).from(qEstimate)
                .where(qEstimate.user.username.eq(username))
                .fetch();

        return estimateList;
    }
}
