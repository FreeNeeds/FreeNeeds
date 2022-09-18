package com.ssafy.backend.db.repository;

import com.ssafy.backend.db.entity.Apply;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplyRepository extends JpaRepository<Apply, Long> {
}
