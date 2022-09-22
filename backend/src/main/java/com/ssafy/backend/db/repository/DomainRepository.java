package com.ssafy.backend.db.repository;

import com.ssafy.backend.db.entity.Domain;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DomainRepository extends JpaRepository<Domain, Long> {
}
