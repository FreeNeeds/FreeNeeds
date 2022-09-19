package com.ssafy.backend.db.repository;

import com.ssafy.backend.db.entity.Career;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CareerRepository extends JpaRepository<Career, Long> {
}
