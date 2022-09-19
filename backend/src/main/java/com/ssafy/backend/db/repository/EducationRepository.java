package com.ssafy.backend.db.repository;

import com.ssafy.backend.db.entity.Education;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EducationRepository extends JpaRepository<Education, Long> {
}
