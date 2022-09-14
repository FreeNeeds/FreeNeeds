package com.ssafy.backend.db.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
    @Column(length = 255)
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
    @Column(length = 255)
    private String period;

    @NotNull
    private int recruitNumber;

    @NotNull
    @Column(length = 255)
    private String deadline;

    @NotNull
    private int careerPeriod;

    @NotNull
    @Column(length = 255)
    private String task;

    @NotNull
    @Column(length = 32)
    private String workStyle;

    @NotNull
    @Column(length = 32)
    private String price;
}
