package com.ssafy.backend.db.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.ssafy.backend.db.entity.Certificate;
import com.ssafy.backend.db.entity.QCertificate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 자격 모델 관련 디비 쿼리 생성을 위한 구현 정의.
 */
@Repository
@RequiredArgsConstructor
public class CertificateRepositorySupport {
    private final JPAQueryFactory jpaQueryFactory;
    QCertificate qCertificate = QCertificate.certificate;

    public List<Certificate> findAllByResumeId(Long resume_id) {
        List<Certificate> certificateList = jpaQueryFactory.select(qCertificate).from(qCertificate)
                .where(qCertificate.resume.resumeId.eq(resume_id))
                .fetch();

        return certificateList;
    }
}
