package com.yoonNeun.MyDreamPartner.domain.survey.domain.dto;

import lombok.Getter;

@Getter
public class Survey {

    private final Integer typeId;
    private final String typeName;
    private final String categoryName;
    private final String summary;
    private final Integer totalScore;

    public Survey(Integer typeId, String typeName, String categoryName, String summary, Integer totalScore) {
        this.typeId = typeId;
        this.typeName = typeName;
        this.categoryName = categoryName;
        this.summary = summary;
        this.totalScore = totalScore;
    }

    public static Survey of (Integer typeId, String typeName, String categoryName, String summary, Integer totalScore) {
        return new Survey(typeId, typeName, categoryName, summary, totalScore);
    }
}
