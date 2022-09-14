package com.ssafy.backend.db.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "resume")
@Getter
@Setter
public class Resume {

    @Id
    @GeneratedValue
    private Long resumeId;

    private String title;
    private String introduce;
    private Integer career_period;

    @OneToOne
    private User user;

}
