package com.yoonNeun.MyDreamPartner.domain.survey.application;

import com.yoonNeun.MyDreamPartner.domain.survey.domain.Survey;
import com.yoonNeun.MyDreamPartner.domain.survey.infrastructure.SurveyRepository;
import com.yoonNeun.MyDreamPartner.domain.survey.infrastructure.SurveyRepositoryCustomImpl;
import com.yoonNeun.MyDreamPartner.domain.type.domain.Type;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class SurveyService {

    private final SurveyRepositoryCustomImpl surveyRepositoryCustomImpl;

    public List<Survey> getSurveyIntroduction() {
        return surveyRepositoryCustomImpl.findSurveyDetails();
    }
}
