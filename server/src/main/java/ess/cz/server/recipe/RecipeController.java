package ess.cz.server.recipe;

import ess.cz.server.common.exchange.GeneralResponse;
import ess.cz.server.recipe.exchange.RecipeRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/recipe")
@RequiredArgsConstructor
public class RecipeController {

    private final RecipeService recipeService;

    @GetMapping("/list")
    public GeneralResponse getAllRecipes() {
        return recipeService.getAllRecipes();
    }

    @PostMapping
    public GeneralResponse saveRecipe(@RequestBody RecipeRequest recipe) {
        return recipeService.saveRecipe(recipe);
    }
}
