package com.ssafy.backend.db.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
public class Project {
    @Id
    @GeneratedValue
    private Long projectId;

    @NotNull
    @Column(length = 16)
    private String title;

    @NotNull
    private String content;

    @NotNull
    @Column(length = 32)
    private String category;

    @NotNull
    @Column(length = 16)
    private String domain;

    @NotNull
    @Column(length = 32)
    private String location;

    @NotNull
    @Column(length = 32)
    private String officeHours;

    @NotNull
    @Column(length = 32)
    private String skill;

    @NotNull
    private String period;

    @NotNull
    private int recruitNumber;

    @NotNull
    private String deadline;

    @NotNull
    private int careerPeriod;

    @NotNull
    private String task;

    @NotNull
    @Column(length = 32)
    private String workStyle;

    @NotNull
    @Column(length = 32)
    private String price;

    //FK : 회사 시리얼
    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name="companyId", referencedColumnName = "companyId")
    private Company company;
}
