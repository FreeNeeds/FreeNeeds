package com.ssafy.backend.api.service;

import com.ssafy.backend.api.request.ProjectRegisterPostReq;
import com.ssafy.backend.db.entity.Company;
import com.ssafy.backend.db.entity.Project;
import com.ssafy.backend.db.entity.ProjectTech;
import com.ssafy.backend.db.entity.Tech;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface ProjectService {

    Page<Project> getProjects(Pageable pageable);
    Project getProjectByProjectId(Long projectId);

    Project createProject(ProjectRegisterPostReq registerInfo, Company company);

    void createProjectTech(Long projectId, List<String> techList);

    List<Tech> getTechsByProjectId(Long projectId);

    List<Project> getProjectsByTechs(List<String> techList, String locationSi, String locationGu, String category, List<String> domainList);

    List<Project> getProjectsByCompanyId(Long companyId);
}
