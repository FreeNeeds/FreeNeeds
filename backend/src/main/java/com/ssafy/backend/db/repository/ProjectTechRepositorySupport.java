package com.ssafy.backend.db.repository;

import com.querydsl.core.types.CollectionExpression;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.ssafy.backend.db.entity.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProjectTechRepositorySupport extends QuerydslRepositorySupport{

    private final JPAQueryFactory jpaQueryFactory;

    QProjectTech qProjectTech = QProjectTech.projectTech;

    public ProjectTechRepositorySupport(JPAQueryFactory jpaQueryFactory) {
        super(ProjectTech.class);
        this.jpaQueryFactory = jpaQueryFactory;
    }

    public List<Tech> getTechListByProjectId(Long projectId){
        // 프로젝트에 해당하는 기술 리스트
        QProjectTech qProjectTech = QProjectTech.projectTech;
        return jpaQueryFactory
                .select(qProjectTech.tech)
                .from(qProjectTech)
                .where(qProjectTech.project.projectId.eq(projectId))
                .fetch();
    }

    public List<Project> getProjectListByTechs(List<Tech> techList, String locationSi, String locationGu, String category, List<String> domainList){


        QProjectTech qProjectTech = QProjectTech.projectTech;
        QProject qProject = QProject.project;
//        QDomain qDomain = QDomain.domain;

        return jpaQueryFactory.select(qProjectTech.project)
                .from(qProjectTech)
                .where(inTechList(techList),
                        eqLocationSi(locationSi),
                        eqLocationGu(locationGu),
                        eqCategory(category),
                        inDomainList(domainList)
                )
                .distinct()
                .fetch();



    }

    private BooleanExpression inTechList(List<Tech> techList) {
        if (techList.isEmpty()) {
            return null;
        }
        return qProjectTech.tech.in(techList);
    }
    private BooleanExpression eqLocationSi(String locationSi) {
        if (StringUtils.isEmpty(locationSi)) {
            return null;
        }
        return qProjectTech.project.locationSi.eq(locationSi);
    }
    private BooleanExpression eqLocationGu(String locationGu) {
        if (StringUtils.isEmpty(locationGu)) {
            return null;
        }
        return qProjectTech.project.locationGu.eq(locationGu);
    }
    private BooleanExpression eqCategory(String category) {
        if (StringUtils.isEmpty(category)) {
            return null;
        }
        return qProjectTech.project.category.eq(category);
    }
    private BooleanExpression inDomainList(List<String> domainList) {
        if (domainList.isEmpty()) {
            return null;
        }
        return qProjectTech.project.domain.in(domainList);
    }

    public Page<Project> getProjectListByTechsPaging(List<Tech> techList, Pageable pageable){


        QProjectTech qProjectTech = QProjectTech.projectTech;

        List<Project> content = jpaQueryFactory
                .select(qProjectTech.project)
                .from(qProjectTech)
                .where(qProjectTech.tech.in(techList))
                .distinct()
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        Long count = jpaQueryFactory
                .select(qProjectTech.project.count())
                .from(qProjectTech)
                .where(qProjectTech.tech.in(techList))
                .distinct()
                .fetchOne();

        return new PageImpl<>(content,pageable,count);
    }

}
