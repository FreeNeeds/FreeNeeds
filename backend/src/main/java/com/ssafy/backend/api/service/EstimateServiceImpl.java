package com.ssafy.backend.api.service;

import com.ssafy.backend.api.request.EstimateRegisterPostReq;
import com.ssafy.backend.db.entity.Estimate;
import com.ssafy.backend.db.entity.User;
import com.ssafy.backend.db.repository.EstimateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 *	평점 관련 비즈니스 로직 처리를 위한 서비스 구현 정의.
 */
@Service("estimateService")
@RequiredArgsConstructor
public class EstimateServiceImpl implements EstimateService{

    private final EstimateRepository estimateRepository;

    @Override
    public void createEstimate(User user, EstimateRegisterPostReq registerEstimateInfo) {
        Estimate estimate = new Estimate();

        estimate.setUser(user);
        estimate.setProfession(registerEstimateInfo.getProfession());
        estimate.setOntime(registerEstimateInfo.getOntime());
        estimate.setActive(registerEstimateInfo.getActive());
        estimate.setCommunication(registerEstimateInfo.getCommunication());
        estimate.setReEmployment(registerEstimateInfo.getReEmployment());

        estimateRepository.save(estimate);
    }
}
