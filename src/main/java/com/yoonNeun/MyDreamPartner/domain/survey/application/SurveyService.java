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

    // 1. 필요한 객체 의존성 주입
    private final SurveyRepositoryCustomImpl surveyRepositoryCustomImpl;

    // 2. 메서드
    public List<Survey> getSurveyIntroduction() {
        // 2-1. DB에서 type_id, type_name, content, total_score을 survey 객체(= DTO)에 담아서 가져온다.
        // 이때, 한 번에 여러 row를 가져와야 하므로 List 형태로 반환한다.
        return surveyRepositoryCustomImpl.findSurveyDetails();
    }
}
