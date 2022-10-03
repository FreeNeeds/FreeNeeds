package com.ssafy.backend.db.repository;

import com.ssafy.backend.db.entity.Apply;
import com.ssafy.backend.db.entity.Project;
import com.ssafy.backend.db.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ApplyRepository extends JpaRepository<Apply, Long> {

    Optional<Apply> findApplyByUserAndProject(User user, Project project);
    List<Apply> findByProject(Project project);
}
