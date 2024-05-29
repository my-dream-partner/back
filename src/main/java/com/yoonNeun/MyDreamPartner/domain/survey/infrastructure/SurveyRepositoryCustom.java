package com.yoonNeun.MyDreamPartner.domain.survey.infrastructure;

import com.yoonNeun.MyDreamPartner.domain.survey.domain.Survey;

import java.util.List;

public interface SurveyRepositoryCustom {
    List<Survey> findSurveyDetails();
}
