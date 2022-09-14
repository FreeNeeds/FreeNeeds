package com.ssafy.backend.db.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "estimate")
@Getter
@Setter
public class Estimate {

    @Id
    @GeneratedValue
    private Long estimateId;

    private Float profession;
    private Float ontime;
    private Float active;
    private Float communication;
    private Float reEmployment;

    @ManyToOne
    private User user;

}
