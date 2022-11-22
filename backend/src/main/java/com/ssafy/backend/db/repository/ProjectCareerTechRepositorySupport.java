package com.ssafy.backend.db.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.ssafy.backend.db.entity.ProjectCareerTech;
import com.ssafy.backend.db.entity.QProjectCareerTech;
import com.ssafy.backend.db.entity.Tech;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProjectCareerTechRepositorySupport extends QuerydslRepositorySupport {
    private final JPAQueryFactory jpaQueryFactory;
    QProjectCareerTech qProjectCareerTech = QProjectCareerTech.projectCareerTech;

    public ProjectCareerTechRepositorySupport(JPAQueryFactory jpaQueryFactory) {
        super(ProjectCareerTech.class);
        this.jpaQueryFactory = jpaQueryFactory;
    }

    public List<Tech> getTechListByProjectCareerId(Long projectCareerId) {
        // 프로젝트 이력에 해당하는 기술 리스트
        return jpaQueryFactory
                .select(qProjectCareerTech.tech)
                .from(qProjectCareerTech)
                .where(qProjectCareerTech.projectCareer.projectCareerId.eq(projectCareerId))
                .fetch();
    }
}
