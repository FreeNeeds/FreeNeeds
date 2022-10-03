package com.ssafy.backend.db.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "contract")
@Getter
@Setter
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long contractId;

    @NotNull
    private String imgSRC;

    @Lob
    @NotNull
    private String content;

    @ManyToOne
    @JoinColumn(name="userId", referencedColumnName = "userId")
    private User user;

    @ManyToOne
    @JoinColumn(name="projectId", referencedColumnName = "projectId")
    private Project project;

}
