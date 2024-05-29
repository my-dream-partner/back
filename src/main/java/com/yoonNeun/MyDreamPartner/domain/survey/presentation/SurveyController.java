package com.yoonNeun.MyDreamPartner.domain.survey.presentation;

import com.yoonNeun.MyDreamPartner.common.response.SuccessResponse;
import com.yoonNeun.MyDreamPartner.domain.survey.application.SurveyService;
import com.yoonNeun.MyDreamPartner.domain.survey.domain.Survey;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class SurveyController {

    // 1. 필요한 객체 의존성 주입
    private final SurveyService surveyService;

    // 2. URI(단, URL은 해당되지 않음)
    @GetMapping("/survey")
    public SuccessResponse<List<Survey>> getSurveyIntroduction() {
        List<Survey> surveys = surveyService.getSurveyIntroduction();
        return new SuccessResponse<>(surveys);
    }
}
