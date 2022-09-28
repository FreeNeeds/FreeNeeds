package com.ssafy.backend.db.repository;

import com.ssafy.backend.db.entity.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletRepository extends JpaRepository<Wallet, Long> {
    Wallet findByUsername(String username);
}
