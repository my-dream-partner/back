package com.yoonNeun.MyDreamPartner.domain.survey.infrastructure;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.yoonNeun.MyDreamPartner.domain.survey.domain.Survey;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

// 수동으로 Q class import
import static com.yoonNeun.MyDreamPartner.domain.type.domain.QType.type;
import static com.yoonNeun.MyDreamPartner.domain.category.domain.QCategory.category;
import static com.yoonNeun.MyDreamPartner.domain.typecategory.domain.QTypeCategory.typeCategory;

@RequiredArgsConstructor
@Repository
public class SurveyRepositoryCustomImpl implements SurveyRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public List<Survey> findSurveyDetails() {
        return queryFactory
                .select(Projections.constructor(Survey.class,
                        type.typeName,
                        category.categoryName,
                        category.summary,
                        type.totalScore))
                .from(typeCategory)
                .join(typeCategory.type, type)
                .join(typeCategory.category, category)
                .fetch();
    }
}
