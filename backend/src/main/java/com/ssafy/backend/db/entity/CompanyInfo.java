package com.ssafy.backend.db.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
public class CompanyInfo {
    @Id
    @GeneratedValue
    private Long id;
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
