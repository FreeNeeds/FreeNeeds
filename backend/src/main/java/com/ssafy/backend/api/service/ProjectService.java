package com.ssafy.backend.api.service;

import com.ssafy.backend.api.request.ProjectRegisterPostReq;
import com.ssafy.backend.db.entity.Company;
import com.ssafy.backend.db.entity.Project;
import com.ssafy.backend.db.entity.ProjectTech;
import com.ssafy.backend.db.entity.Tech;

import java.util.List;

public interface ProjectService {

    List<Project> getProjects();
    Project getProjectByProjectId(Long projectId);

    Project createProject(ProjectRegisterPostReq registerInfo, Company company);

    void createProjectTech(Long projectId, List<String> techList);

    List<Tech> getTechsByProjectId(Long projectId);

    List<Project> getProjectsByTechs(List<String> techList);
}
