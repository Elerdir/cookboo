package ess.cz.server.recipe;

import ess.cz.server.common.exchange.GeneralResponse;
import ess.cz.server.common.util.StatusCode;
import ess.cz.server.recipe.dto.Recipe;
import ess.cz.server.recipe.exchange.RecipeRequest;
import ess.cz.server.recipe.model.RecipeEntity;
import ess.cz.server.recipe.repository.RecipeRepository;
import ess.cz.server.recipetag.dto.RecipeTag;
import ess.cz.server.tag.TagService;
import ess.cz.server.tag.dto.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RecipeService {

    private final TagService tagService;

    private final RecipeRepository recipeRepository;

    public GeneralResponse getAllRecipes() {

        return GeneralResponse.builder()
                .statusCode(StatusCode.OK.getCode())
                .message(null)
                .object(null)
                .build();
    }

    public GeneralResponse saveRecipe(RecipeRequest recipe) {
        HashMap<String, String> tagMaps = getTagsWithId(recipe);

        recipeRepository.saveAndFlush(RecipeEntity.fromDto(Recipe.fromRequest(recipe, tagMaps)));


        return GeneralResponse.builder()
                .statusCode(StatusCode.OK.getCode())
                .message(null)
                .object(null)
                .build();
    }

    private HashMap<String, String> getTagsWithId(RecipeRequest recipe) {
        HashMap<String, String> tags =new HashMap<>();
        Collection<Tag> existingTags = (Collection<Tag>) tagService.getAllTags().getObject();

        Collection<String> newTags = recipe.getRecipeTags().stream()
                .filter(rt -> existingTags.stream()
                        .noneMatch(t -> t.getTagName().equals(rt)))
                .toList();

        existingTags.forEach(tag -> {
            tags.put(tag.getTagName(), tag.getId());
        });

        if (newTags.size() > 0) {
            tagService.saveAllTags(newTags).forEach(tag -> {
                tags.put(tag.getTagName(), tag.getId());
            });
        }

        return tags;
    }
}
