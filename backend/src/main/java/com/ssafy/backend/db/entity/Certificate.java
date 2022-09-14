package com.ssafy.backend.db.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "cerfificate")
@Getter
@Setter
public class Certificate {
    @Id
    @GeneratedValue
    private Long certificateId;

    @NotNull
    private String date;

    @NotNull
    private String name;

    @ManyToOne
    @JoinColumn(name="resumeId", referencedColumnName = "resumeId")
    private Resume resume;

}
