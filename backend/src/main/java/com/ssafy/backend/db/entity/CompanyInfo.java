package com.ssafy.backend.db.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
public class CompanyInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long companyInfoId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id", unique = true)
    private Company company;

    @NotNull
    private String ceo;

    @NotNull
    private String address;

    @NotNull
    private String companyCall;

    @NotNull
    private String registrationNumber;

    @NotNull
    private String registrationFile;
}
