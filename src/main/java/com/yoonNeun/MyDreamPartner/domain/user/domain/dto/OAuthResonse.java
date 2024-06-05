package com.yoonNeun.MyDreamPartner.domain.user.domain.dto;

import lombok.Getter;

@Getter
public class OAuthResonse {

    private final String id;
    private final String email;
    private final String name;

    public OAuthResonse(String id, String email, String name) {
        this.id = id;
        this.email = email;
        this.name = name;
    }

    public static OAuthResonse of(String oauthId, String email, String name) {
        return new OAuthResonse(oauthId, email, name);
    }
}
