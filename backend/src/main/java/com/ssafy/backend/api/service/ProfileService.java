package com.ssafy.backend.api.service;

import com.ssafy.backend.db.entity.Tech;

import java.util.List;

public interface ProfileService {
    List<Tech> getTechsByProfileId(Long profileId);
}
