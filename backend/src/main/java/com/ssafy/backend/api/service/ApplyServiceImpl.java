package com.ssafy.backend.api.service;


import com.ssafy.backend.common.model.response.BaseResponseBody;
import com.ssafy.backend.db.entity.Apply;
import com.ssafy.backend.db.entity.Project;
import com.ssafy.backend.db.entity.User;
import com.ssafy.backend.db.repository.ApplyRepository;
import com.ssafy.backend.db.repository.ApplyRepositorySupport;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service("applyService")
@RequiredArgsConstructor
public class ApplyServiceImpl implements ApplyService{

    private final ApplyRepository applyRepository;

    private final ApplyRepositorySupport applyRepositorySupport;

//    @Override
//    public List<Apply> getApply(User user) {
//        return applyRepository.findAll().stream().filter(v -> v.getUser() == user).collect(Collectors.toList());
//    }

    @Override
    public List<Apply> getApplyByUserId(Long userId) {
        return applyRepositorySupport.findAllByUserId(userId);
    }

    @Override
    public List<Apply> getApplyByProejctId(Project project) {

        return applyRepository.findByProject(project);

    }

    @Override
    public Apply createApply(String state, User user, Project project) {
        Apply apply = new Apply();
        apply.setState(state);
        apply.setUser(user);
        apply.setProject(project);
        return applyRepository.save(apply);
    }

    @Override
    public Apply updateApply(String state, User user, Project project) {
        Apply apply = applyRepository.findApplyByUserAndProject(user, project).get();
        apply.setState(state);
        return applyRepository.save(apply);
    }

    @Override
    public BaseResponseBody deleteApply(User user, Project project) {
        Long applyId = applyRepository.findApplyByUserAndProject(user, project).get().getApplyId();
        applyRepository.deleteById(applyId);
        return BaseResponseBody.of(200, "Success");
    }

    @Override
    public boolean alreadyApply(User user, Project project) {
        return applyRepository.findApplyByUserAndProject(user, project).isPresent();
    }
}
