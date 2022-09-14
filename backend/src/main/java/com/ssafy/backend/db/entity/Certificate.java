package com.ssafy.backend.db.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "cerfificate")
@Getter
@Setter
public class Certificate {
    @Id
    @GeneratedValue
    private Long certificateId;

    private String date;
    private String name;

    @ManyToOne
    private Resume resume;

}
