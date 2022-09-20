package com.ssafy.backend.db.entity;

import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long profileId;

    private String title;

    private String introduce;

    private int creer_period;

    //FK : 유저(프리랜서) 시리얼
    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name="userId", referencedColumnName = "userId")
    private User user;

    @Builder
    public Profile(Long profileId, String title, String introduce, int creer_period, User user) {
        this.profileId = profileId;
        this.title = title;
        this.introduce = introduce;
        this.creer_period = creer_period;
        this.user = user;
    }
}
