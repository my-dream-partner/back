package com.yoonNeun.MyDreamPartner.domain.survey.infrastructure;

import com.yoonNeun.MyDreamPartner.domain.survey.domain.entity.Type;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SurveyRepository extends JpaRepository<Type, Integer>, SurveyRepositoryCustom {
}
