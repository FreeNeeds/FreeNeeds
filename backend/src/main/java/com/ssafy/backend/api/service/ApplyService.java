package com.ssafy.backend.api.service;

import com.ssafy.backend.common.model.response.BaseResponseBody;
import com.ssafy.backend.db.entity.Apply;
import com.ssafy.backend.db.entity.Project;
import com.ssafy.backend.db.entity.User;

public interface ApplyService {

    Apply getApply(User user, Project project);
    Apply createApply(String state, User user, Project project);

    Apply updateApply(String state, User user, Project project);

    BaseResponseBody deleteApply(User user, Project project);
}
