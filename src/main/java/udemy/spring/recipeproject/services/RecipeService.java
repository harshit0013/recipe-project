package udemy.spring.recipeproject.services;

import udemy.spring.recipeproject.commands.RecipeCommand;
import udemy.spring.recipeproject.domain.Recipe;

import java.util.Set;

public interface RecipeService {
    Set<Recipe> getRecipes();
    Recipe findById(Long l);
    RecipeCommand findCommandById(Long l);
    RecipeCommand saveRecipeCommand(RecipeCommand command);
    void deleteById(Long l);
}
