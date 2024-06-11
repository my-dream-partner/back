package com.yoonNeun.MyDreamPartner.domain.survey.domain.entity;

import com.yoonNeun.MyDreamPartner.domain.user.domain.entity.User;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "response")
public class Response {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer responseId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    private LocalDateTime submittedAt;

    @OneToMany(mappedBy = "response")
    private List<ResponseDetail> responseDetails;

    @Builder
    public Response(User user, LocalDateTime submittedAt) {
        this.user = user;
        this.submittedAt = submittedAt;
    }
}
