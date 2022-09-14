package com.ssafy.backend.db.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tech")
@Getter
@Setter
public class Tech {
    @Id
    @GeneratedValue
    private Long techId;

    @NotNull
    private String name;

    @ManyToOne
    @JoinColumn(name="resumeId", referencedColumnName = "resumeId")
    private Resume resume;

}
