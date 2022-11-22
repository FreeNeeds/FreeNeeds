package com.ssafy.backend.db.repository;

import com.ssafy.backend.db.entity.Certificate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CertificateRepository extends JpaRepository<Certificate, Long> {
}
