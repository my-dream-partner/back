package com.yoonNeun.MyDreamPartner.domain.oauth.domain;

import lombok.Getter;

@Getter
public class AuthToken {

    private final String accessToken;
    private final String refreshToken;
    private final String grantType;
    private final Long expiresIn;

    public AuthToken(String accessToken, String refreshToken, String grantType, Long expiresIn) {
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
        this.grantType = grantType;
        this.expiresIn = expiresIn;
    }

    public static AuthToken of(String accessToken, String refreshToken, String grantType, Long expiresIn) {
        return new AuthToken(accessToken, refreshToken, grantType, expiresIn);
    }
}
