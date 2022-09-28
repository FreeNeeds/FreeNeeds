package com.ssafy.backend.db.repository;

import com.ssafy.backend.db.entity.Estimate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstimateRepository extends JpaRepository<Estimate, Long> {
}
