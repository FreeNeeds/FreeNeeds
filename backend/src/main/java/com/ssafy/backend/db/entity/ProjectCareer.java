package com.ssafy.backend.db.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "projectCareer")
@Getter
@Setter
public class ProjectCareer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long projectCareerId;

    @NotNull
    private String category;

    @NotNull
    private String domain;

    @NotNull
    private String companyName;

    @NotNull
    private String title;

    @NotNull
    private String content;

    @NotNull
    @Temporal(TemporalType.DATE)
    private Date start_date;

    @NotNull
    @Temporal(TemporalType.DATE)
    private Date end_date;

    @ManyToOne
    @JoinColumn(name="userId", referencedColumnName = "userId")
    private User user;
}
