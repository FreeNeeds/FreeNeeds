package com.ssafy.backend.db.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "wallet")
@Getter
@Setter
public class Wallet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long walletId;

    @NotNull
    @Column(length = 16)
    private String username;

    @NotNull
    private String accountAddress;
}
