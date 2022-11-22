package com.ssafy.backend.db.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "estimate")
@Getter
@Setter
public class Estimate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long estimateId;

    @NotNull
    private Float profession;

    @NotNull
    private Float ontime;

    @NotNull
    private Float active;

    @NotNull
    private Float communication;

    @NotNull
    private Float reEmployment;

    @ManyToOne
    @JoinColumn(name="userId", referencedColumnName = "userId")
    private User user;

}
