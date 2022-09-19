package com.ssafy.backend.db.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.ssafy.backend.db.entity.*;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProfileTechRepositorySupport extends QuerydslRepositorySupport {
    private final JPAQueryFactory jpaQueryFactory;
    QProfileTech qProfileTech = QProfileTech.profileTech;


    public ProfileTechRepositorySupport(JPAQueryFactory jpaQueryFactory) {
        super(ProfileTech.class);
        this.jpaQueryFactory = jpaQueryFactory;
    }

    public List<User> getFreelancerListByTechs(List<Tech> techList){


        QProfileTech qProfileTech = QProfileTech.profileTech;

        List<User> profiles = jpaQueryFactory
                .select(qProfileTech.profile.user)
                .from(qProfileTech)
                .where(qProfileTech.tech.in(techList))
                .distinct()
                .fetch();

        return profiles;
    }
}
