package com.ssafy.backend.api.service;

import com.ssafy.backend.db.entity.Tech;
import com.ssafy.backend.db.repository.ProfileTechRepositorySupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("profileService")
public class ProfileServiceImpl implements ProfileService{

    @Autowired
    ProfileTechRepositorySupport profileTechRepositorySupport;

    @Override
    public List<Tech> getTechsByProfileId(Long profileId) {
        // 프로젝트 이력에 해당하는 기술 조회
        return profileTechRepositorySupport.getTechListByProfileId(profileId);
    }
}
