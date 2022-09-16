package com.ssafy.backend.api.service;

import com.ssafy.backend.api.request.ProjectRegisterPostReq;
import com.ssafy.backend.db.entity.Company;
import com.ssafy.backend.db.entity.Project;

public interface ProjectServie {

    Project getProjectByProjectId(Long projectId);

    Project createProject(ProjectRegisterPostReq registerInfo, Company company);
}
