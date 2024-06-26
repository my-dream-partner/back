package com.yoonNeun.MyDreamPartner.domain.survey.presentation;

import com.yoonNeun.MyDreamPartner.common.response.SuccessResponse;
import com.yoonNeun.MyDreamPartner.domain.survey.application.SurveyService;
import com.yoonNeun.MyDreamPartner.domain.survey.domain.dto.Survey;
import com.yoonNeun.MyDreamPartner.domain.survey.domain.dto.SurveyDescription;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Validated
@RestController
@RequiredArgsConstructor
public class SurveyController {

    private final SurveyService surveyService;

    @GetMapping("/survey")
    public SuccessResponse<List<Survey>> getSurveyIntroduction() {
        List<Survey> surveys = surveyService.getSurveyIntroduction();
        return new SuccessResponse<>(surveys);
    }

    @GetMapping("/survey/description")
    public SuccessResponse<SurveyDescription> getSurveyDescription(@RequestParam @NotBlank @Size(min = 4, max = 6) String type) {
        SurveyDescription surveyDescription = surveyService.getSurveyDescription(type);
        return new SuccessResponse<>(surveyDescription);
    }
}
