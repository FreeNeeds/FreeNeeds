package com.ssafy.backend.db.repository;

import java.util.List;
import java.util.Optional;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.ssafy.backend.db.entity.Project;
import com.ssafy.backend.db.entity.QProject;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

@Repository

public class ProjectRepositorySupport extends QuerydslRepositorySupport {
    private final JPAQueryFactory jpaQueryFactory;

    QProject qProject = QProject.project;

    public ProjectRepositorySupport(JPAQueryFactory jpaQueryFactory) {
        super(Project.class);
        this.jpaQueryFactory = jpaQueryFactory;
    }

    public Optional<Project> findProjectByProjectId(Long pId){
        Project project= jpaQueryFactory.selectFrom(qProject).where(qProject.projectId.eq(pId)).fetchOne();
        return Optional.ofNullable(project) ;
    }

    public List<Project> findProjectsByProjectId(Long pId){
        return jpaQueryFactory.selectFrom(qProject).where(qProject.projectId.eq(pId)).fetch();
    }

    public List<Project> findProjectsByCompanyId(Long companyId){
        return jpaQueryFactory.selectFrom(qProject).where(qProject.company.companyId.eq(companyId)).fetch();
    }



}
