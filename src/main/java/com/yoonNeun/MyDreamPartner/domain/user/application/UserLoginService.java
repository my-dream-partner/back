package com.yoonNeun.MyDreamPartner.domain.user.application;

import com.yoonNeun.MyDreamPartner.domain.user.domain.dto.AuthToken;
import com.yoonNeun.MyDreamPartner.domain.user.domain.AuthTokenGenerator;
import com.yoonNeun.MyDreamPartner.domain.user.domain.dto.OAuthResonse;
import com.yoonNeun.MyDreamPartner.domain.user.domain.entity.User;
import com.yoonNeun.MyDreamPartner.domain.user.infrastructure.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserLoginService {

    private final OAuthService oAuthService;
    private final UserRepository userRepository;
    private final AuthTokenGenerator authTokenGenerator;

    public AuthToken socialLogin(String code, String registrationId) {
        OAuthResonse oAuthResonse = oAuthService.login(code, registrationId);
        Integer userId = checkExistingUser(oAuthResonse);

        return authTokenGenerator.generate(userId);
    }

    private Integer checkExistingUser(OAuthResonse oAuthResonse) {
        return userRepository.findByEmail(oAuthResonse.getEmail())
                .map(User::getUserId)
                .orElseGet(() -> addUser(oAuthResonse));
    }

    private Integer addUser(OAuthResonse oAuthResonse) {
        User user = User.builder()
                .email(oAuthResonse.getEmail())
                .username(oAuthResonse.getName())
                .build();

        userRepository.save(user);

        return user.getUserId();
    }
}
