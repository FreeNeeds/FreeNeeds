package com.ssafy.backend.db.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.ssafy.backend.db.entity.QResume;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

/**
 * 이력서 모델 관련 디비 쿼리 생성을 위한 구현 정의.
 */
@Repository
@RequiredArgsConstructor
public class ResumeRepositorySupport {
    private final JPAQueryFactory jpaQueryFactory;
    QResume qResume = QResume.resume;

    public Long findResumeIdByUsername(String username) {
        Long resume_id = jpaQueryFactory.select(qResume.resumeId).from(qResume)
                .where(qResume.user.username.eq(username))
                .fetchOne();

        return resume_id;
    }
}
