package ess.cz.server.recipe.model;

import ess.cz.server.recipe.dto.Recipe;
import ess.cz.server.recipetag.model.RecipeTagEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.Collection;
import java.util.UUID;
import java.util.stream.Collectors;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE, staticName = "of")
@Entity
@Table(name = "recipe")
public class RecipeEntity {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "recipe_name")
    private String recipeName;

    private String instructions;

    private String ingredients;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Collection<RecipeTagEntity> recipeTags;

    public static Collection<RecipeEntity> fromDtos(Collection<Recipe> recipes) {
        return recipes.stream()
                .map(RecipeEntity::fromDto)
                .collect(Collectors.toList());
    }

    public static RecipeEntity fromDto(Recipe recipe) {
        String randomId = String.valueOf(UUID.randomUUID());

        return RecipeEntity.builder()
                .id((recipe.getId() != null) ? recipe.getId() : randomId)
                .recipeName(recipe.getRecipeName())
                .instructions(recipe.getInstructions())
                .ingredients(recipe.getIngredients())
                .recipeTags(RecipeTagEntity.fromDtos(recipe.getRecipeTags(), randomId))
                .build();
    }
}
