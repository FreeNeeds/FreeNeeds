package com.ssafy.backend.db.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
public class Company {
    @Id
    @GeneratedValue
    private Long companyId;

    @NotNull
    @Column(length = 16)
    private String username;

    @NotNull
    private String email;

    @NotNull
    private String name;

    @NotNull
    private String phone;

    @JsonIgnore
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
}
