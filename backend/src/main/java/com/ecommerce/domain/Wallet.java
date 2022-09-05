package com.ecommerce.domain;

import lombok.Data;
import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * Sub PJT Ⅱ
 */
@Data
public class Wallet {
	private long id;
	private long ownerId;
	private String address;
	private BigDecimal balance = BigDecimal.valueOf(0);
	private int receivingCount = 0;
	private int cash = 0;

	public boolean canRequestEth(){
		return this.receivingCount < 10;
	}
}
