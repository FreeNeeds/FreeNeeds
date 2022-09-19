package com.ssafy.backend.api.service;

import com.ssafy.backend.db.entity.Tech;
import com.ssafy.backend.db.repository.ProjectCareerTechRepositorySupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("projectCareerService")
public class ProjectCareerServiceImpl implements ProjectCareerService{

    @Autowired
    ProjectCareerTechRepositorySupport projectCareerTechRepositorySupport;

    @Override
    public List<Tech> getTechsByProjectCareerId(Long projectCareerId) {
        // 프로젝트 이력에 해당하는 기술 조회
        return projectCareerTechRepositorySupport.getTechListByProjectCareerId(projectCareerId);
    }
}
