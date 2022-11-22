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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long resumeId;

    @OneToOne
    @JoinColumn(name="userId", referencedColumnName = "userId")
    private User user;

}
