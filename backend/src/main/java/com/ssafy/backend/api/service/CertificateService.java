package com.ssafy.backend.api.service;

import com.ssafy.backend.api.response.UserCertificateRes;

import java.util.List;

/**
 *	자격 관련 비즈니스 로직 처리를 위한 서비스 인터페이스 정의.
 */
public interface CertificateService {
    List<UserCertificateRes> getCertificateAllListByResumeId(Long resume_id);
}

