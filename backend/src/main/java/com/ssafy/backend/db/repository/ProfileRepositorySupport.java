package com.ssafy.backend.db.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.ssafy.backend.db.entity.Profile;
import com.ssafy.backend.db.entity.Project;
import com.ssafy.backend.db.entity.QProfile;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class ProfileRepositorySupport extends QuerydslRepositorySupport {
    private final JPAQueryFactory jpaQueryFactory;
    QProfile qProfile = QProfile.profile;
    public ProfileRepositorySupport(JPAQueryFactory jpaQueryFactory) {
        super(Profile.class);
        this.jpaQueryFactory = jpaQueryFactory;
    }

    public Optional<Profile> findProfileByProfileId(Long pId){
        Profile profile= jpaQueryFactory.selectFrom(qProfile).where(qProfile.profileId.eq(pId)).fetchOne();
        return Optional.ofNullable(profile) ;
    }
}
