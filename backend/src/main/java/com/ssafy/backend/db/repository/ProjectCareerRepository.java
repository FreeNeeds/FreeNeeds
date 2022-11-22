package com.ssafy.backend.db.repository;

import com.ssafy.backend.db.entity.ProjectCareer;
import com.ssafy.backend.db.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectCareerRepository extends JpaRepository<ProjectCareer, Long> {
    List<ProjectCareer> findAllByUser(User user);
    ProjectCareer findProjectCareerByProjectCareerId(Long projectCareerId);
}
