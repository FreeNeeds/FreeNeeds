package com.ssafy.backend.api.service;

import com.ssafy.backend.api.response.UserCareerRes;
import com.ssafy.backend.db.entity.Career;
import com.ssafy.backend.db.repository.CareerRepositorySupport;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 *	경력 관련 비즈니스 로직 처리를 위한 서비스 구현 정의.
 */
@Service("careerService")
@RequiredArgsConstructor
public class CareerServiceImpl implements CareerService{

    private final CareerRepositorySupport careerRepositorySupport;

    @Override
    public List<UserCareerRes> getCareerAllListByResumeId(Long resume_id) {
        List<Career> careerList = careerRepositorySupport.findAllByResumeId(resume_id);

        List<UserCareerRes> res = new ArrayList<>();
        for (Career career : careerList) {
            res.add(UserCareerRes.of(career));
        }

        return res;
    }
}
