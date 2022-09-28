package com.ssafy.backend.api.service;

import com.ssafy.backend.db.entity.Wallet;

/**
 *	지갑 관련 비즈니스 로직 처리를 위한 서비스 인터페이스 정의.
 */
public interface WalletService {
    Wallet createWallet(String username, String accountAddress);

    Wallet getWalletByUsername(String username);

    void updateWallet(String username, String accountAddress);
}
