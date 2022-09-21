package com.ssafy.backend.db.repository;

import com.ssafy.backend.db.entity.Estimate;
import com.ssafy.backend.db.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EstimateRepository extends JpaRepository<Estimate, Long> {
    List<Estimate> findAllByUser(User user);
}
