package com.ecommerce.application;

import com.ecommerce.domain.Purchase;
import org.springframework.transaction.annotation.Transactional;

public interface IEscrowContractService {
    @Transactional
    Purchase checkDeposit(int pid);
}
