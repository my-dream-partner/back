package com.yoonNeun.MyDreamPartner.domain.user.domain.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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

    @NotBlank
    private String gender;

    @NotNull
    private Integer age;

    @NotBlank
    private String position;

    @Builder
    public UserProfile(User user, String gender, Integer age, String position) {
        this.user = user;
        this.gender = gender;
        this.age = age;
        this.position = position;
    }
}
