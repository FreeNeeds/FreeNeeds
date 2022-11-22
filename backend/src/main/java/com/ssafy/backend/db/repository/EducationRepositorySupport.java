package com.ssafy.backend.db.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.ssafy.backend.db.entity.Education;
import com.ssafy.backend.db.entity.QEducation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

/**
 * 학력 모델 관련 디비 쿼리 생성을 위한 구현 정의.
 */
@Repository
@RequiredArgsConstructor
public class EducationRepositorySupport {
    private final JPAQueryFactory jpaQueryFactory;
    QEducation qEducation = QEducation.education;

    public Education findEducationByResumeId(Long resume_id) {
        Education education = jpaQueryFactory.select(qEducation).from(qEducation)
                .where(qEducation.resume.resumeId.eq(resume_id))
                .fetchOne();

        return  education;
    }
}
