package com.ssafy.backend.db.repository;

import com.ssafy.backend.db.entity.Contract;
import com.ssafy.backend.db.entity.Project;
import com.ssafy.backend.db.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ContractRepository extends JpaRepository<Contract, Long> {
}
