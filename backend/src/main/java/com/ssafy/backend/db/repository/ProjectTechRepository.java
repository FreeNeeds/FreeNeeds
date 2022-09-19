package com.ssafy.backend.db.repository;


import com.ssafy.backend.db.entity.ProjectTech;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectTechRepository extends JpaRepository<ProjectTech, Long> {

    @Override
    List<ProjectTech> findAll();

}
