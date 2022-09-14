package com.ssafy.backend.db.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "education")
@Getter
@Setter
public class Education {
    @Id
    @GeneratedValue
    private Long bachelorId;

    @NotNull
    private String period;

    @NotNull
    private String name;

    @ManyToOne
    @JoinColumn(name="resumeId", referencedColumnName = "resumeId")
    private Resume resume;
}
