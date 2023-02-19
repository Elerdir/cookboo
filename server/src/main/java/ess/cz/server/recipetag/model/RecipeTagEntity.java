package ess.cz.server.recipetag.model;

import ess.cz.server.recipetag.dto.RecipeTag;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

import java.util.Collection;
import java.util.stream.Collectors;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE, staticName = "of")
@Entity
@Table(name = "recipe_tag")
public class RecipeTagEntity {

    @EmbeddedId
    private RecipeTadPk recipeTadPk;

    public static Collection<RecipeTagEntity> fromDtos(Collection<RecipeTag> recipeTags, String randomId) {
        return recipeTags.stream()
                .map(RecipeTagEntity::fromDto)
                .collect(Collectors.toList());
    }

    public static RecipeTagEntity fromDto(RecipeTag recipeTag) {
        return RecipeTagEntity.builder()
                .recipeTadPk(RecipeTadPk.of(recipeTag.getRecipeId(), recipeTag.getTagId()))
                .build();
    }
}
