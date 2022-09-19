package com.ssafy.backend.db.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "career")
@Getter
@Setter
public class Career {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long careerId;

    @NotNull
    private String companyName;

    private String department;

    private String position;

    @NotNull
    @Temporal(TemporalType.DATE)
    private Date start_date;

    @NotNull
    @Temporal(TemporalType.DATE)
    private Date end_date;

    @ManyToOne
    @JoinColumn(name="resumeId", referencedColumnName = "resumeId")
    private Resume resume;
}
