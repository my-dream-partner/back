package com.yoonNeun.MyDreamPartner.domain.survey.infrastructure;

import com.yoonNeun.MyDreamPartner.domain.survey.domain.Survey;
import com.yoonNeun.MyDreamPartner.domain.survey.domain.SurveyDescription;

import java.util.List;

public interface SurveyRepositoryCustom {
    List<Survey> findSurveyIntroductionDetails();

    SurveyDescription findSurveyDescription(String type);

    List<String> findCategoryNamesByType(String type);

    List<String> findSummariesByType(String type);
}
