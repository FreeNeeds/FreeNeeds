package com.ssafy.backend.api.service;

import com.ssafy.backend.db.entity.Tech;

import java.util.List;

public interface ProjectCareerService {
    List<Tech> getTechsByProjectCareerId(Long projectCareerId);
}
