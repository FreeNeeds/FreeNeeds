package com.ssafy.backend.db.repository;

import com.ssafy.backend.db.entity.Resume;
import com.ssafy.backend.db.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResumeRepository extends JpaRepository<Resume, Long> {
    Resume findResumeByUser(User user);
}
