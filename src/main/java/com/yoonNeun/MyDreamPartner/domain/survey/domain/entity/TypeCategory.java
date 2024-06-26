package com.yoonNeun.MyDreamPartner.domain.survey.domain.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "type_category")
public class TypeCategory {

    @EmbeddedId
    private TypeCategoryId typeCategoryId;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("typeId")
    @JoinColumn(name = "type_id", insertable = false, updatable = false)
    private Type type;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("categoryId")
    @JoinColumn(name = "category_id", insertable = false, updatable = false)
    private Category category;
}
