package com.ssafy.backend.db.repository;

import com.ssafy.backend.db.entity.Project;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface ProjectRepository extends JpaRepository<Project, Long> {

    @Override
    Page<Project> findAll(Pageable pageable);

}