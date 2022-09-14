package com.ssafy.backend.db.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "resume")
@Getter
@Setter
public class Resume {

    @Id
    @GeneratedValue
    private Long resumeId;

    @NotNull
    private String title;

    private String introduce;

    @NotNull
    private Integer career_period;

    @OneToOne
    @JoinColumn(name="freelancerId", referencedColumnName = "id")
    private User user;

}
