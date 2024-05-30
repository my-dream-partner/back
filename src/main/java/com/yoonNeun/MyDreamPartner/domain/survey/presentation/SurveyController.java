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

    private final SurveyService surveyService;

    @GetMapping("/survey")
    public SuccessResponse<List<Survey>> getSurveyIntroduction() {
        List<Survey> surveys = surveyService.getSurveyIntroduction();
        return new SuccessResponse<>(surveys);
    }
}
