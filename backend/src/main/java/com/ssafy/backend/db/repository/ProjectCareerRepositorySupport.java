package com.ssafy.backend.db.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.ssafy.backend.db.entity.ProjectCareer;
import com.ssafy.backend.db.entity.QProjectCareer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 프로젝트 이력 모델 관련 디비 쿼리 생성을 위한 구현 정의.
 */
@Repository
@RequiredArgsConstructor
public class ProjectCareerRepositorySupport {
    private final JPAQueryFactory jpaQueryFactory;
    QProjectCareer qProjectCareer = QProjectCareer.projectCareer;

    public List<ProjectCareer> findAllByUsername(String username) {
        List<ProjectCareer> projectCareerList = jpaQueryFactory.select(qProjectCareer).from(qProjectCareer)
                .where(qProjectCareer.user.username.eq(username))
                .fetch();

        return projectCareerList;
    }
}
