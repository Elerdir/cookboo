package ess.cz.server.recipetag.dto;

import ess.cz.server.recipetag.model.RecipeTagEntity;
import lombok.*;

import java.util.Collection;
import java.util.stream.Collectors;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE, staticName = "of")
public class RecipeTag {

    private String recipeId;

    private String tagId;

    public static Collection<RecipeTag> fromEntity(Collection<RecipeTagEntity> recipeTags) {
        return recipeTags.stream()
                .map(RecipeTag::fromEntity)
                .collect(Collectors.toList());
    }

    public static RecipeTag fromEntity(RecipeTagEntity recipeTag) {
        return RecipeTag.builder()
                .recipeId(recipeTag.getRecipeTadPk().getRecipeId())
                .tagId(recipeTag.getRecipeTadPk().getTagId())
                .build();
    }
}
