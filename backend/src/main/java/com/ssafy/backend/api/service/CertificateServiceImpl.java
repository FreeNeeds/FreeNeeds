package com.ssafy.backend.api.service;

import com.ssafy.backend.api.response.UserCareerRes;
import com.ssafy.backend.api.response.UserCertificateRes;
import com.ssafy.backend.db.entity.Career;
import com.ssafy.backend.db.entity.Certificate;
import com.ssafy.backend.db.repository.CertificateRepositorySupport;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 *	자격 관련 비즈니스 로직 처리를 위한 서비스 구현 정의.
 */
@Service("certificateService")
@RequiredArgsConstructor
public class CertificateServiceImpl implements CertificateService{

    private final CertificateRepositorySupport certificateRepositorySupport;

    @Override
    public List<UserCertificateRes> getCertificateAllListByResumeId(Long resume_id) {
        List<Certificate> certificateList = certificateRepositorySupport.findAllByResumeId(resume_id);

        List<UserCertificateRes> res = new ArrayList<>();
        for (Certificate certificate : certificateList) {
            res.add(UserCertificateRes.of(certificate));
        }

        return res;
    }
}
