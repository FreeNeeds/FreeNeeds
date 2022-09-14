package com.ssafy.backend.db.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
public class Apply {
    @Id
    @GeneratedValue
    private Long userProjectId;

    @NotNull
    @Column(length = 255)
    private String state;

    //FK : 프리랜서 시리얼
    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name="freelancerId", referencedColumnName = "id")
    private User user;

    //FK : 프로젝트 시리얼
    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name="projectId", referencedColumnName = "projectId")
    private Project project;
}
