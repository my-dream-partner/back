package com.yoonNeun.MyDreamPartner.domain.user.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "user_profiles")
public class UserProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userProfileId;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String gender;
    private Long age;
    private String position;

    @Builder
    public UserProfile(User user, String gender, Long age, String position) {
        this.user = user;
        this.gender = gender;
        this.age = age;
        this.position = position;
    }
}
