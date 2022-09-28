package com.ssafy.backend.db.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString

public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long projectId;

    @NotNull
    @Column(length = 32)
    private String category;

    @NotNull
    @Column(length = 255)
    private String locationSi;

    @NotNull
    @Column(length = 255)
    private String locationGu;

    @NotNull
    @Column(length = 255)
    private String skill;

    @NotNull
    @Column(length = 255)
    private String title;

    @NotNull
    private String content;


    @NotNull
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date startDate;

    @NotNull
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date endDate;

    @NotNull
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date deadline;

    @NotNull
    private int recruitNumber;

    @NotNull
    private String task;

    @NotNull
    @Column(length = 32)
    private String workStyle;

    @NotNull
    @Column(length = 32)
    private String workStartTime;

    @NotNull
    @Column(length = 32)
    private String workEndTime;

    @NotNull
    @Column(length = 32)
    private String lowPrice;

    @NotNull
    @Column(length = 32)
    private String highPrice;

    @NotNull
    private int careerPeriod;

    @NotNull
    @Column(length = 255)
    private String domain;

    //FK : 회사 시리얼
    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name="companyId", referencedColumnName = "companyId")
//    @JsonIgnore

    private Company company;

//    @OneToMany(mappedBy = "project")
//    @JsonIgnore
//    private List<Domain> domains = new ArrayList<>();


    @Builder
    public Project(String category, String locationSi, String locationGu, String skill, String title, String content, Date startDate, Date endDate, Date deadline, int recruitNumber, String task, String workStyle, String workStartTime, String workEndTime, String lowPrice, String highPrice, int careerPeriod, Company company, String domain) {
        this.category = category;
        this.locationSi = locationSi;
        this.locationGu = locationGu;
        this.skill = skill;
        this.title = title;
        this.content = content;
        this.startDate = startDate;
        this.endDate = endDate;
        this.deadline = deadline;
        this.recruitNumber = recruitNumber;
        this.task = task;
        this.workStyle = workStyle;
        this.workStartTime = workStartTime;
        this.workEndTime = workEndTime;
        this.lowPrice = lowPrice;
        this.highPrice = highPrice;
        this.careerPeriod = careerPeriod;
        this.company = company;
        this.domain =domain;

    }
}
