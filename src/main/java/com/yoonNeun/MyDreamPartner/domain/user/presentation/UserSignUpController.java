package com.yoonNeun.MyDreamPartner.domain.user.presentation;

import com.yoonNeun.MyDreamPartner.common.response.SuccessResponse;
import com.yoonNeun.MyDreamPartner.domain.user.application.UserSignUpService;
import jakarta.validation.constraints.*;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RequiredArgsConstructor
@RestController
public class UserSignUpController {

    // 1. Service DI
    private final UserSignUpService userSignUpService;

    // 2. post
    // 응답 Dto가 따로 없을 경우, 그냥 SuccessResponse만 작성하면 됨
    @PostMapping("/user/profile")
    public SuccessResponse SignUpController (@RequestParam @NotNull @Positive @Min(20) Integer age,
                                             @RequestParam @NotBlank @Size(max = 1) String gender,
                                             @RequestParam @NotBlank @Size(min = 3, max = 15) String position) {
        userSignUpService.addUserProfile(age, gender, position);

        return new SuccessResponse<>();
    }
}
