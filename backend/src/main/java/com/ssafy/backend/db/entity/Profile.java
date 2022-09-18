package com.ssafy.backend.db.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Profile {
    @Id
    @GeneratedValue
    private Long profileId;

    private String title;

    private String introduce;

    private int creer_period;


    //@Lob
    @Column(
            columnDefinition = "TEXT"
    )
    private String skill;

    //FK : 유저(프리랜서) 시리얼
    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name="userId", referencedColumnName = "userId")
    private User user;
}
