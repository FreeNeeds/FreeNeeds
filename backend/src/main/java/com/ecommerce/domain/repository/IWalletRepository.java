package com.ecommerce.domain.repository;

import com.ecommerce.domain.Wallet;

import java.math.BigDecimal;
import java.util.List;

public interface IWalletRepository {
	List<Wallet> list();
	Wallet get(long id);
	Wallet get(String wAddress);
	
	long create(Wallet wallet);
	int updateBalance(String wAddress, BigDecimal balance, int cash);
	int updateRequestNo(String wAddress);
}
