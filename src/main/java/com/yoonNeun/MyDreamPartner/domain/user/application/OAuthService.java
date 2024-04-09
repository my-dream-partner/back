package com.yoonNeun.MyDreamPartner.domain.user.application;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.core.env.Environment;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class OAuthService {

    private final Environment env;
    private final RestTemplate restTemplate = new RestTemplate();

    public OAuthService(Environment env) {
        this.env = env;
    }

    public void socialLogin(String code, String registrationId) {
        String accessToken = getAccessToken(code, registrationId);
        JsonNode userResourceNode = getUserResource(accessToken, registrationId);
        // System.out.println("userResourceNode = " + userResourceNode);

        // String id = userResourceNode.get("id").asText();
        // String email = userResourceNode.get("email").asText();
        // String nickname = userResourceNode.get("name").asText();

        // System.out.println("id = " + id);
        // System.out.println("email = " + email);
        // System.out.println("nickname = " + nickname);
    }

    private String getAccessToken(String authorizationCode, String registrationId) {
        String clientId = env.getProperty("oauth2." + registrationId + ".client-id"); // application-oauth.yaml ("oauth2.google.client-id")
        String clientSecret = env.getProperty("oauth2." + registrationId + ".client-secret");
        String redirectUri = env.getProperty("oauth2." + registrationId + ".redirect-uri");
        String tokenUri = env.getProperty("oauth2." + registrationId + ".token-uri");

        validateTokenUri(tokenUri);

        HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(createTokenRequestBody(authorizationCode, clientId, clientSecret, redirectUri), createTokenRequestHeaders());
        ResponseEntity<JsonNode> responseNode = restTemplate.exchange(tokenUri, HttpMethod.POST, entity, JsonNode.class);

        return Optional.ofNullable(responseNode.getBody())
                .map(body -> body.get("access_token").asText())
                .orElse(null);
    }

    private JsonNode getUserResource(String accessToken, String registrationId) {
        String resourceUri = env.getProperty("oauth2." + registrationId + ".resource-uri");

        validateResourceUri(resourceUri);

        HttpEntity<Void> entity = new HttpEntity<>(createUserResourceRequestHeaders(accessToken));

        return restTemplate.exchange(resourceUri, HttpMethod.GET, entity, JsonNode.class).getBody();
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

        for (Map.Entry<String, List<String>> entry : params.entrySet()) {
            System.out.println(entry);
        }

        return params;
    }

    private HttpHeaders createTokenRequestHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        return headers;
    }

    private void validateResourceUri(String resourceUri) {
        if (resourceUri == null) {
            throw new IllegalArgumentException("Resource URI must not be null");
        }
    }

    private HttpHeaders createUserResourceRequestHeaders(String accessToken) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + accessToken);

        return headers;
    }
}