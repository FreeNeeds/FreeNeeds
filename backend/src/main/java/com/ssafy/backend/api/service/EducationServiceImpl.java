package com.ssafy.backend.api.service;

import com.ssafy.backend.api.response.UserEducationRes;
import com.ssafy.backend.db.entity.Education;
import com.ssafy.backend.db.repository.EducationRepositorySupport;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 *	학력 관련 비즈니스 로직 처리를 위한 서비스 구현 정의.
 */
@Service("educationService")
@RequiredArgsConstructor
public class EducationServiceImpl implements EducationService{
    private final EducationRepositorySupport educationRepositorySupport;

    @Override
    public UserEducationRes getEducationByResumeId(Long resume_id) {
        Education education = educationRepositorySupport.findEducationByResumeId(resume_id);

        return UserEducationRes.of(education);
    }
}
