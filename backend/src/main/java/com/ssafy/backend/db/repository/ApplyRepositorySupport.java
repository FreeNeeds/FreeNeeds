package com.ssafy.backend.db.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.ssafy.backend.db.entity.Apply;
import com.ssafy.backend.db.entity.QApply;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ApplyRepositorySupport {
    private final JPAQueryFactory jpaQueryFactory;

    QApply qApply = QApply.apply;

    public List<Apply> findAllByUserId(Long userId) {
        List<Apply> applyList = jpaQueryFactory.select(qApply).from(qApply)
                .where(qApply.user.userId.eq(userId))
                .fetch();

        return applyList;
    }
}
