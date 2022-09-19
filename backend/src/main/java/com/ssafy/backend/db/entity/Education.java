package com.ssafy.backend.db.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "education")
@Getter
@Setter
public class Education {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bachelorId;

    @NotNull
    private String highschool;

    @NotNull
    @Temporal(TemporalType.DATE)
    private Date highschool_start_date;

    @NotNull
    @Temporal(TemporalType.DATE)
    private Date highschool_end_date;

    @NotNull
    private String university;

    @NotNull
    @Temporal(TemporalType.DATE)
    private Date university_start_date;

    @NotNull
    @Temporal(TemporalType.DATE)
    private Date university_end_date;

    @NotNull
    private String major;

    @ManyToOne
    @JoinColumn(name="resumeId", referencedColumnName = "resumeId")
    private Resume resume;
}
