package com.ssafy.backend.db.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.ssafy.backend.db.entity.Career;
import com.ssafy.backend.db.entity.QCareer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 경력 모델 관련 디비 쿼리 생성을 위한 구현 정의.
 */
@Repository
@RequiredArgsConstructor
public class CareerRepositorySupport {
    private final JPAQueryFactory jpaQueryFactory;
    QCareer qCareer = QCareer.career;

    public List<Career> findAllByResumeId(Long resume_id) {
        List<Career> careerList = jpaQueryFactory.select(qCareer).from(qCareer)
                .where(qCareer.resume.resumeId.eq(resume_id))
                .fetch();

        return careerList;
    }
}
