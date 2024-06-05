package com.yoonNeun.MyDreamPartner.domain.user.presentation;

import com.yoonNeun.MyDreamPartner.common.response.SuccessResponse;
import com.yoonNeun.MyDreamPartner.domain.user.domain.dto.AuthToken;
import com.yoonNeun.MyDreamPartner.domain.user.application.UserLoginService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/login/oauth2", produces = "application/json")
@Slf4j
public class UserLoginController {
    private final UserLoginService userLoginService;

    @GetMapping("/code/{registrationId}")
    public SuccessResponse<AuthToken> googleLogin(@RequestParam String code, @PathVariable String registrationId) {
        AuthToken authToken = userLoginService.socialLogin(code, registrationId);
        return new SuccessResponse<>(authToken);
    }
}
