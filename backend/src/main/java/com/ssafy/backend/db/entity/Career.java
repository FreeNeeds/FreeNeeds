package com.ssafy.backend.db.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "career")
@Getter
@Setter
public class Career {
    @Id
    @GeneratedValue
    private Long careerId;

    @NotNull
    private String period;

    @NotNull
    private String name;

    private String grade;

    @ManyToOne
    @JoinColumn(name="resumeId", referencedColumnName = "resumeId")
    private Resume resume;
}
