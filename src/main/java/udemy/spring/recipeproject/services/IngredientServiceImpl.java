package udemy.spring.recipeproject.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import udemy.spring.recipeproject.commands.IngredientCommand;
import udemy.spring.recipeproject.converters.IngredientToIngredientCommand;
import udemy.spring.recipeproject.domain.Recipe;
import udemy.spring.recipeproject.repositories.RecipeRepository;

import java.util.Optional;

@Slf4j
@Service
public class IngredientServiceImpl implements IngredientService {
    private final IngredientToIngredientCommand command;
    private final RecipeRepository recipeRepository;

    public IngredientServiceImpl(IngredientToIngredientCommand command, RecipeRepository recipeRepository) {
        this.command = command;
        this.recipeRepository = recipeRepository;
    }

    @Override
    public IngredientCommand findByRecipeIdAndIngredientId(Long recipeId, Long ingredientId) {
        Optional<Recipe> recipeOptional = recipeRepository.findById(recipeId);
        if(!recipeOptional.isPresent())
        {
            // Todo error handling
            log.debug("Recipe Id is not found : " + recipeId);
        }
        Recipe recipe = recipeOptional.get();

        Optional<IngredientCommand> optionalIngredientCommand = recipe.getIngredients().stream()
                .filter(ingredient -> ingredient.getId().equals(ingredientId))
                .map(ingredient -> command.convert(ingredient)).findFirst();
        if(!optionalIngredientCommand.isPresent())
        {
            // Todo error handling
            log.debug("Ingredient Id is not found : " + ingredientId);
        }

        return optionalIngredientCommand.get();
    }
}
