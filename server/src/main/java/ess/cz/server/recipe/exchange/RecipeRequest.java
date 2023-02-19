package ess.cz.server.recipe.exchange;

import ess.cz.server.recipetag.dto.RecipeTag;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Getter
@NoArgsConstructor
public class RecipeRequest {

    private String id;

    private String recipeName;

    private String instructions;

    private String ingredients;

    private Collection<String> recipeTags;
}
