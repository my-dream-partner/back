package com.yoonNeun.MyDreamPartner.domain.survey.infrastructure;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.yoonNeun.MyDreamPartner.domain.survey.domain.Survey;
import com.yoonNeun.MyDreamPartner.domain.survey.domain.SurveyDescription;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.yoonNeun.MyDreamPartner.domain.type.domain.QType.type;
import static com.yoonNeun.MyDreamPartner.domain.category.domain.QCategory.category;
import static com.yoonNeun.MyDreamPartner.domain.typecategory.domain.QTypeCategory.typeCategory;

@RequiredArgsConstructor
@Repository
public class SurveyRepositoryCustomImpl implements SurveyRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public List<Survey> findSurveyIntroductionDetails() {
        return queryFactory
                .select(Projections.constructor(Survey.class,
                        type.typeId,
                        type.typeName,
                        category.categoryName,
                        category.summary,
                        type.totalScore))
                .from(typeCategory)
                .join(typeCategory.type, type)
                .join(typeCategory.category, category)
                .fetch();
    }

    @Override
    public SurveyDescription findSurveyDescription(String typeName) {
        return queryFactory
                .select(Projections.constructor(SurveyDescription.class,
                        type.typeName,
                        type.content,
                        type.totalScore))
                .from(typeCategory)
                .join(typeCategory.type, type)
                .join(typeCategory.category, category)
                .where(type.typeName.eq(typeName))
                .fetchFirst();
    }

    public List<String> findCategoryNamesByType(String typeName) {
        return queryFactory
                .select(category.categoryName)
                .from(typeCategory)
                .join(typeCategory.category, category)
                .join(typeCategory.type, type)
                .where(type.typeName.eq(typeName))
                .fetch();
    }

    public List<String> findSummariesByType(String typeName) {
        return queryFactory
                .select(category.summary)
                .from(typeCategory)
                .join(typeCategory.category, category)
                .join(typeCategory.type, type)
                .where(type.typeName.eq(typeName))
                .fetch();
    }
}
