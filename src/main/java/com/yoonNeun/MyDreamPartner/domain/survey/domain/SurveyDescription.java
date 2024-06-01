package com.yoonNeun.MyDreamPartner.domain.survey.domain;

import lombok.Getter;

import java.util.List;

@Getter
public class SurveyDescription {

    private final String typeName;
    private final String content;
    private final Integer totalScore;
    private final List<String> categoryName;
    private final List<String> summary;

    public SurveyDescription(String typeName, String content, Integer totalScore, List<String> categoryName, List<String> summary) {
        this.typeName = typeName;
        this.content = content;
        this.totalScore = totalScore;
        this.categoryName = categoryName;
        this.summary = summary;
    }

    public SurveyDescription(String typeName, String content, Integer totalScore) {
        this.typeName = typeName;
        this.content = content;
        this.totalScore = totalScore;
        this.categoryName = null;
        this.summary = null;
    }

    public static SurveyDescription of (String typeName, String content, Integer totalScore, List<String> categoryName, List<String> summary) {
        return new SurveyDescription(typeName, content, totalScore, categoryName, summary);
    }
}
