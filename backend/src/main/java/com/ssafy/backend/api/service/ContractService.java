package com.ssafy.backend.api.service;

import com.ssafy.backend.api.request.ContractRegisterPostReq;
import com.ssafy.backend.db.entity.Contract;
import com.ssafy.backend.db.entity.Project;
import com.ssafy.backend.db.entity.User;

public interface ContractService {
    void createContract(Project project, User user, ContractRegisterPostReq registerContractInfo);

    Contract getContractByUserIdAndProjectId(Long userId, Long projectId);
}
