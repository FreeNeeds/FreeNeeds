package com.ssafy.backend.db.repository;

import com.ssafy.backend.db.entity.Contract;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContractRepository extends JpaRepository<Contract, Long> {
}
