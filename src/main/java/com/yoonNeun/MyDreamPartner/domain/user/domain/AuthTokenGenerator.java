package com.yoonNeun.MyDreamPartner.domain.user.domain;

import com.yoonNeun.MyDreamPartner.common.security.provider.JwtTokenProvider;
import com.yoonNeun.MyDreamPartner.domain.user.domain.dto.AuthToken;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@RequiredArgsConstructor
public class AuthTokenGenerator {

    private static final String BEARER_TYPE = "Bearer";
    private static final long ACCESS_TOKEN_EXPIRE_TIME = 1000 * 60 * 30; // 30분
    private static final long REFRESH_TOKEN_EXPIRE_TIME = 1000 * 60 * 60 * 24 * 7; // 7일

    private final JwtTokenProvider jwtTokenProvider;

    public AuthToken generate(Integer userId) {
        long now = (new Date()).getTime();
        Date accessTokenExpiredDate = new Date(now + ACCESS_TOKEN_EXPIRE_TIME);
        Date refreshTokenExpiredDate = new Date(now + REFRESH_TOKEN_EXPIRE_TIME);

        String subject = userId.toString();
        String accessToken = jwtTokenProvider.generateToken(subject, accessTokenExpiredDate);
        String refreshToken = jwtTokenProvider.generateToken(subject, refreshTokenExpiredDate);

        return AuthToken.of(accessToken, refreshToken, BEARER_TYPE, ACCESS_TOKEN_EXPIRE_TIME / 1000L);
    }

    public Long extractUserId(String accessToken) {
        return Long.valueOf(jwtTokenProvider.extractSubject(accessToken));
    }
}
