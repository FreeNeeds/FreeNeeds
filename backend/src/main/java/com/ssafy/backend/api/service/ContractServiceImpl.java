package com.ssafy.backend.api.service;

import com.ssafy.backend.api.request.ContractRegisterPostReq;
import com.ssafy.backend.db.entity.Contract;
import com.ssafy.backend.db.entity.Project;
import com.ssafy.backend.db.entity.User;
import com.ssafy.backend.db.repository.ContractRepository;
import com.ssafy.backend.db.repository.ContractRepositorySupport;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 *	계약 관련 비즈니스 로직 처리를 위한 서비스 구현 정의.
 */
@Service("contractService")
@RequiredArgsConstructor
public class ContractServiceImpl implements  ContractService{

    private final ContractRepository contractRepository;
    private final ContractRepositorySupport contractRepositorySupport;

    @Override
    public void createContract(Project project, User user, ContractRegisterPostReq registerContractInfo) {
        Contract contract = new Contract();

        contract.setUser(user);
        contract.setProject(project);
        contract.setImgSRC(registerContractInfo.getImgSRC());
        contract.setContent(registerContractInfo.getContent());

        contractRepository.save(contract);
    }

    @Override
    public Contract getContractByUserIdAndProjectId(Long userId, Long projectId) {
        return contractRepositorySupport.findContractByUserIdAndProjectId(userId, projectId);
    }

    @Override
    public void updateContract(Long userId, Long projectId, String content) {
        Contract contract = contractRepositorySupport.findContractByUserIdAndProjectId(userId, projectId);
        System.out.println("뿡");

        contractRepository.delete(contract);
        System.out.println("뿡뿡뿡뿡");
        contract.setContent(content);
        contractRepository.save(contract);
    }
}
