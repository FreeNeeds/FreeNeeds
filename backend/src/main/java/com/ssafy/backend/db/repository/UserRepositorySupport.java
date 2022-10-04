package com.ssafy.backend.db.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.ssafy.backend.db.entity.*;

import java.util.Optional;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

/**
 * 유저 모델 관련 디비 쿼리 생성을 위한 구현 정의.
 */
@Repository
@RequiredArgsConstructor
public class UserRepositorySupport{

    private final JPAQueryFactory jpaQueryFactory;
    QUser qUser = QUser.user;

    QProfile qProfile = QProfile.profile;

    QProjectCareer qProjectCareer = QProjectCareer.projectCareer;

    public Optional<User> findUserByUsername(String username) {
        User user = jpaQueryFactory.select(qUser).from(qUser)
                .where(qUser.username.eq(username)).fetchOne();
        if(user == null) return Optional.empty();
        return Optional.ofNullable(user);
    }

    public Profile findProfileByUserId(Long userId) {
        Profile profile = jpaQueryFactory.select(qProfile).from(qProfile)
                .where(qProfile.user.userId.eq(userId))
                .fetchOne();

        return profile;
    }

    public Profile findProfileByUsername(String username) {
        Profile profile = jpaQueryFactory.select(qProfile).from(qProfile)
                .where(qProfile.user.username.eq(username))
                .fetchOne();

        return profile;
    }

    public ProjectCareer findProjectCareerByUsername(String username) {
        ProjectCareer projectCareer = jpaQueryFactory.select(qProjectCareer).from(qProjectCareer)
                .where(qProjectCareer.user.username.eq(username))
                .fetchOne();

        return projectCareer;
    }

    public String findUserAccountAddressByUsername(String username) {
        String accountAddress = jpaQueryFactory.select(qUser.accountAddress).from(qUser)
                .where(qUser.username.eq(username)).fetchOne();
        return accountAddress;
    }

    public String findUserAccountAddressByUserId(Long userId) {
        String accountAddress = jpaQueryFactory.select(qUser.accountAddress).from(qUser)
                .where(qUser.userId.eq(userId)).fetchOne();
        return accountAddress;
    }

    public String findUsernameByUserId(Long userId) {
        String username = jpaQueryFactory.select(qUser.username).from(qUser)
                .where(qUser.userId.eq(userId)).fetchOne();
        return username;
    }

//    public boolean existsByUsername(String username){
//        return  jpaQueryFactory.selectFrom(qUser).from(qUser)
//                .where(qUser.userId.eq(userId)).fetchOne();
//    }
}
