package com.ssafy.backend.api.service;

import com.ssafy.backend.api.request.EstimateRegisterPostReq;
import com.ssafy.backend.api.response.EstimateRes;
import com.ssafy.backend.db.entity.Estimate;
import com.ssafy.backend.db.entity.User;

import java.util.List;

public interface EstimateService {
    void createEstimate(User user, EstimateRegisterPostReq registerEstimateInfo);

    List<EstimateRes> getEstimateAllList(String username);
}
