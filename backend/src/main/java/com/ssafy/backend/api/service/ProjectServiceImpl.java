package com.ssafy.backend.api.service;

import com.ssafy.backend.api.request.ProjectRegisterPostReq;
import com.ssafy.backend.db.entity.*;
import com.ssafy.backend.db.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("projectService")
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    ProjectRepositorySupport projectRepositorySupport;

    @Autowired
    ProjectTechRepository projectTechRepository;

    @Autowired
    ProjectTechRepositorySupport projectTechRepositorySupport;

    @Autowired
    TechRepository techRepository;

    @Override
    public Project createProject(ProjectRegisterPostReq registerInfo, Company company) {

        Project project = Project.builder()
                .category(registerInfo.getCategory())
                .locationSi(registerInfo.getLocationSi())
                .locationGu(registerInfo.getLocationGu())
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
                .domain(registerInfo.getDomain())
                .company(company)
                .build();
//         projectRepository.flush();
        projectRepository.save(project);
//
//         Domain domain = Domain.builder()
//                .domainName(registerInfo.getDomain())
//                .project(project).build();
//         System.out.println(domain);
//         domainRepository.save(domain);
//         domainRepository.flush();
        return project;

    }


    @Override
    public Page<Project> getProjects(Pageable pageable) {
        // 프로젝트 전체 조회
        return projectRepository.findAll(pageable);
    }

    @Override
    public Project getProjectByProjectId(Long projectId) {
        // 프로젝트 조회(projectId를 통한 조회)
        Project project = projectRepositorySupport.findProjectByProjectId(projectId).get();
        return project;
    }


    @Override
    public void createProjectTech(Long projectId, List<String> techList) {
        // 프로젝트 기술 저장

        for(String t : techList){
            ProjectTech temp = new ProjectTech();
            temp.setProject(projectRepositorySupport.findProjectByProjectId(projectId).get());
            temp.setTech((Tech) techRepository.findById(t).get());
            projectTechRepository.save(temp);
        }

    }

    @Override
    public List<Tech> getTechsByProjectId(Long projectId) {
        // 프로젝트에 해당하는 기술 조회
        return projectTechRepositorySupport.getTechListByProjectId(projectId);
    }

    @Override
    public List<Project> getProjectsByTechs(List<String> techList, String locationSi, String locationGu, String category, List<String> domainList) {
        // 프로젝트 필터링 조회

        // tech리스트 객체화
        List<Tech> nlist = new ArrayList<>();
        for(String t : techList){
            Tech temp = techRepository.findById(t).get();
            nlist.add(temp);
        }

        return projectTechRepositorySupport.getProjectListByTechs(nlist,locationSi,locationGu,category,domainList);

    }

    @Override
    public List<Project> getProjectsByCompanyId(Long companyId) {
        return projectRepositorySupport.findProjectsByCompanyId(companyId);
    }


}
