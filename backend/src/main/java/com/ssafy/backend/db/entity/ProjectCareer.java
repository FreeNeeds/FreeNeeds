package com.ssafy.backend.db.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "projectCareer")
@Getter
@Setter
public class ProjectCareer {

    @Id
    @GeneratedValue
    private Long projectCareerId;

    @NotNull
    private String title;

    @NotNull
    private String content;

    @NotNull
    private String category;

    @NotNull
    private String domain;

    @NotNull
    private String location;

    @NotNull
    private String officehours;

    @NotNull
    private String skill;

    @NotNull
    private String period;

    @NotNull
    private Integer recruitNumber;

    @NotNull
    private String deadline;

    @NotNull
    private Integer careerPeriod;

    @NotNull
    private String task;

    @NotNull
    private String workstyle;

    @NotNull
    private String price;

    @ManyToOne
    @JoinColumn(name="freelancerId", referencedColumnName = "id")
    private User user;
}
