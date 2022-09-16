package com.ssafy.backend.api.service;

import com.ssafy.backend.api.request.ProjectRegisterPostReq;
import com.ssafy.backend.db.entity.Company;
import com.ssafy.backend.db.entity.Project;
import com.ssafy.backend.db.repository.ProjectRepository;
import com.ssafy.backend.db.repository.ProjectRepositorySupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("projectService")
public class ProjectServiceImpl implements ProjectServie {

    @Autowired
    ProjectRepository projectRepository;


    @Autowired
    ProjectRepositorySupport projectRepositorySupport;

    @Override
    public Project createProject(ProjectRegisterPostReq registerInfo, Company company) {

        Project project = Project.builder()
                .category(registerInfo.getCategory())
                .domain(registerInfo.getDomain())
                .location(registerInfo.getLocation())
                .skill(registerInfo.getSkill())
                .title(registerInfo.getTitle())
                .content(registerInfo.getContent())
                .startDate(registerInfo.getStartDate())
                .endDate(registerInfo.getEndDate())
                .deadline(registerInfo.getDeadline())
                .recruitNumber(registerInfo.getRecruitNumber())
                .task(registerInfo.getTask())
                .workStyle(registerInfo.getWorkStyle())
                .workStartTime(registerInfo.getWorkStartTime())
                .workEndTime(registerInfo.getWorkEndTime())
                .lowPrice(registerInfo.getLowPrice())
                .highPrice(registerInfo.getHighPrice())
                .careerPeriod(registerInfo.getCareerPeriod())
                .company(company)
                .build();

        return projectRepository.save(project);
    }
    @Override
    public Project getProjectByProjectId(Long projectId) {
        // 프로젝트 조회(projectId를 통한 조회)
        Project project = projectRepositorySupport.findProjectByProjectId(projectId).get();
        return project;
    }


}
