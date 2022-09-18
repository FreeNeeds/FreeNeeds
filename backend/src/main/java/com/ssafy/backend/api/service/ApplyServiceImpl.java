package com.ssafy.backend.api.service;


import com.ssafy.backend.db.entity.Apply;
import com.ssafy.backend.db.entity.Project;
import com.ssafy.backend.db.entity.User;
import com.ssafy.backend.db.repository.ApplyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service("applyService")
@RequiredArgsConstructor
public class ApplyServiceImpl implements ApplyService{

    private final ApplyRepository applyRepository;

    @Override
    public Apply createApply(String state, User user, Project project) {
        Apply apply = new Apply();
        apply.setState(state);
        apply.setUser(user);
        apply.setProject(project);
        return applyRepository.save(apply);
    }
}
