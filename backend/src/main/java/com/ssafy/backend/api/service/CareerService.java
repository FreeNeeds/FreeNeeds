package com.ssafy.backend.api.service;

import com.ssafy.backend.api.response.UserCareerRes;

import java.util.List;

/**
 *	경력 관련 비즈니스 로직 처리를 위한 서비스 인터페이스 정의.
 */
public interface CareerService {
    List<UserCareerRes> getCareerAllListByResumeId(Long resume_id);
}
