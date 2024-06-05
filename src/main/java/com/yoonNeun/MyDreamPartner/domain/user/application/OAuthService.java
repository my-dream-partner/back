package com.yoonNeun.MyDreamPartner.domain.user.application;

import com.fasterxml.jackson.databind.JsonNode;
import com.yoonNeun.MyDreamPartner.domain.user.domain.dto.OAuthResonse;
import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

@RequiredArgsConstructor
@Service
public class OAuthService {

    private final Environment env;
    private final RestTemplate restTemplate = new RestTemplate();

    public OAuthResonse login(String code, String registrationId) {
        String accessToken = getAccessTokenAndRefreshToken(code, registrationId); // Google API의 액세스 토큰
        return getUserResource(accessToken, registrationId);
    }

    private String getAccessTokenAndRefreshToken(String authorizationCode, String registrationId) {
        String clientId = env.getProperty("oauth2." + registrationId + ".client-id"); // application-oauth.yaml ("oauth2.google.client-id")
        String clientSecret = env.getProperty("oauth2." + registrationId + ".client-secret");
        String redirectUri = env.getProperty("oauth2." + registrationId + ".redirect-uri");
        String tokenUri = env.getProperty("oauth2." + registrationId + ".token-uri");

        validateTokenUri(tokenUri);

        HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(createTokenRequestBody(authorizationCode, clientId, clientSecret, redirectUri), createTokenRequestHeaders());
        ResponseEntity<JsonNode> responseNode = restTemplate.exchange(tokenUri, HttpMethod.POST, entity, JsonNode.class);
        JsonNode accessTokenNode = responseNode.getBody();

        return Objects.requireNonNull(accessTokenNode).get("access_token").asText();
    }

    private OAuthResonse getUserResource(String accessToken, String registrationId) {
        String resourceUri = env.getProperty("oauth2." + registrationId + ".resource-uri");
        validateResourceUri(resourceUri);
        HttpEntity<Void> entity = new HttpEntity<>(createUserResourceRequestHeaders(accessToken));

        return restTemplate.exchange(resourceUri, HttpMethod.GET, entity, OAuthResonse.class).getBody();
    }

    private void validateTokenUri(String tokenUri) {
        if (tokenUri == null) {
            throw new IllegalArgumentException("Token URI must not be null");
        }
    }

    private MultiValueMap<String, String> createTokenRequestBody(String authorizationCode, String clientId, String clientSecret, String redirectUri) {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("code", authorizationCode);
        params.add("client_id", clientId);
        params.add("client_secret", clientSecret);
        params.add("redirect_uri", redirectUri);
        params.add("grant_type", "authorization_code");

        return params;
    }

    private HttpHeaders createTokenRequestHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED); // application_form_urlencoded

        return headers;
    }

    private void validateResourceUri(String resourceUri) {
        if (resourceUri == null) {
            throw new IllegalArgumentException("Resource URI must not be null");
        }
    }

    private HttpHeaders createUserResourceRequestHeaders(String accessToken) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + accessToken); // Bearer

        return headers;
    }
}
