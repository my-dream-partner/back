package com.yoonNeun.MyDreamPartner.domain.survey.application;

import com.yoonNeun.MyDreamPartner.domain.survey.domain.Survey;
import com.yoonNeun.MyDreamPartner.domain.survey.domain.SurveyDescription;
import com.yoonNeun.MyDreamPartner.domain.survey.infrastructure.SurveyRepositoryCustomImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class SurveyService {

    private final SurveyRepositoryCustomImpl surveyRepositoryCustomImpl;

    public List<Survey> getSurveyIntroduction() {
        return surveyRepositoryCustomImpl.findSurveyIntroductionDetails();
    }

    public SurveyDescription getSurveyDescription(String type) {

        SurveyDescription surveyDescription = surveyRepositoryCustomImpl.findSurveyDescription(type);

        List<String> categoryNames = surveyRepositoryCustomImpl.findCategoryNamesByType(type);

        List<String> summaries = surveyRepositoryCustomImpl.findSummariesByType(type);

        return new SurveyDescription(surveyDescription.getTypeName(), surveyDescription.getContent(), surveyDescription.getTotalScore(), categoryNames, summaries);
    }
}
