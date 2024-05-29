package com.yoonNeun.MyDreamPartner.domain.typecategory.domain;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@Embeddable
public class TypeCategoryId implements Serializable {

    private Integer typeId;
    private Integer categoryId;

    public TypeCategoryId(Integer typeId, Integer categoryId) {
        this.typeId = typeId;
        this.categoryId = categoryId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TypeCategoryId that)) return false;
        return Objects.equals(typeId, that.typeId) && Objects.equals(categoryId, that.categoryId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(typeId, categoryId);
    }
}
