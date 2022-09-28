package com.ssafy.backend.api.service;

import com.ssafy.backend.db.entity.Wallet;
import com.ssafy.backend.db.repository.WalletRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 *	지갑 관련 비즈니스 로직 처리를 위한 서비스 구현 정의.
 */
@Service("walletService")
@RequiredArgsConstructor
public class WalletServiceImpl implements WalletService{

    private final WalletRepository walletRepository;

    @Override
    public Wallet createWallet(String username, String accountAddress) {
        Wallet wallet = new Wallet();

        wallet.setUsername(username);
        wallet.setAccountAddress(accountAddress);

        walletRepository.save(wallet);

        return wallet;
    }

    @Override
    public Wallet getWalletByUsername(String username) {
        return walletRepository.findByUsername(username);
    }

    @Override
    public void updateWallet(String username, String accountAddress) {
        Wallet wallet = walletRepository.findByUsername(username);

        wallet.setAccountAddress(accountAddress);

        walletRepository.save(wallet);
    }
}
