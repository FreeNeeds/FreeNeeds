package com.ssafy.backend.api.service;

import com.ssafy.backend.db.entity.Apply;
import com.ssafy.backend.db.entity.Project;
import com.ssafy.backend.db.entity.User;

public interface ApplyService {
    Apply createApply(String state, User user, Project project);
}
