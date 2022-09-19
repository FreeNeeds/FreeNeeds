package com.ssafy.backend.db.repository;

import com.ssafy.backend.db.entity.Tech;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TechRepository extends JpaRepository<Tech, String> {
}
