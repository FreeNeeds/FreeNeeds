package com.ssafy.backend.api.service;

import com.ssafy.backend.api.request.EstimateRegisterPostReq;
import com.ssafy.backend.api.response.EstimateRes;
import com.ssafy.backend.db.entity.Estimate;
import com.ssafy.backend.db.entity.User;
import com.ssafy.backend.db.repository.EstimateRepository;
import com.ssafy.backend.db.repository.EstimateRepositorySupport;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 *	평점 관련 비즈니스 로직 처리를 위한 서비스 구현 정의.
 */
@Service("estimateService")
@RequiredArgsConstructor
public class EstimateServiceImpl implements EstimateService{

    private final EstimateRepository estimateRepository;
    private final EstimateRepositorySupport estimateRepositorySupport;

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

    @Override
    public List<EstimateRes> getEstimateAllList(String username) {
        List<Estimate> estimateList = estimateRepositorySupport.findAllByUsername(username);

        List<EstimateRes> res = new ArrayList<>();

        for (Estimate estimate : estimateList) {
            res.add(EstimateRes.of(estimate));
        }

        return res;
    }
}
