package ess.cz.server.recipe.dto;

import ess.cz.server.recipe.exchange.RecipeRequest;
import ess.cz.server.recipetag.dto.RecipeTag;
import lombok.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.UUID;
import java.util.stream.Collectors;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE, staticName = "of")
public class Recipe {

    private String id;

    private String recipeName;

    private String instructions;

    private String ingredients;

    private Collection<RecipeTag> recipeTags;

    public static Recipe fromRequest(RecipeRequest recipe, HashMap<String, String> tagMaps) {
        String randomId = String.valueOf(UUID.randomUUID());

        return Recipe.builder()
                .id(randomId)
                .recipeName(recipe.getRecipeName())
                .ingredients(recipe.getIngredients())
                .recipeTags(recipe.getRecipeTags().stream()
                        .map(rt -> RecipeTag.builder()
                                .recipeId(randomId)
                                .tagId(tagMaps.get(rt))
                                .build())
                        .collect(Collectors.toList()))
                .build();
    }
}
