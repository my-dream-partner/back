package com.yoonNeun.MyDreamPartner.domain.user.application;

import com.yoonNeun.MyDreamPartner.domain.user.infrastructure.UserSignUpRepository;
import com.yoonNeun.MyDreamPartner.domain.user.domain.entity.UserProfile;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserSignUpService {

    private final UserSignUpRepository userSignUpRepository;

    public void addUserProfile(Integer age, String gender, String position) {
        UserProfile userProfile = UserProfile.builder()
                .age(age)
                .gender(gender)
                .position(position)
                .build();

        userSignUpRepository.save(userProfile);
    }
}
