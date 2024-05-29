package com.yoonNeun.MyDreamPartner.domain.type.domain;

import com.yoonNeun.MyDreamPartner.domain.typecategory.domain.TypeCategory;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Set;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "type")
public class Type {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer typeId;

    @NotBlank
    private String typeName;
    
    @NotBlank
    private String content;

    @NotNull
    private Integer totalScore;

    @OneToMany(mappedBy = "type")
    private Set<TypeCategory> typeCategories;
}
