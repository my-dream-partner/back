package com.yoonNeun.MyDreamPartner.domain.survey.domain;

import lombok.Getter;

@Getter
public class Survey {

    // 1. 필요한 데이터
    // 난이도 이름(type_name), 항목 이름(category_name), 항목 내용(summary), 총 점수(total_score)
    private final String typeName;
    private final String categoryName;
    private final String summary;
    private final Integer totalScore;

    public Survey(String typeName, String categoryName, String summary, Integer totalScore) {
        this.typeName = typeName;
        this.categoryName = categoryName;
        this.summary = summary;
        this.totalScore = totalScore;
    }

    public static Survey of (String typeName, String categoryName, String summary, Integer totalScore) {
        return new Survey(typeName, categoryName, summary, totalScore);
    }
}
