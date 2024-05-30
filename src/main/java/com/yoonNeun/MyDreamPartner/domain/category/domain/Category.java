package com.yoonNeun.MyDreamPartner.domain.category.domain;

import com.yoonNeun.MyDreamPartner.domain.type.domain.Type;
import com.yoonNeun.MyDreamPartner.domain.typecategory.domain.TypeCategory;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Set;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categoryId;

    @NotBlank
    private String categoryName;

    @NotBlank
    private String summary;

    @OneToMany(mappedBy = "category")
    private Set<TypeCategory> typeCategories;
}
