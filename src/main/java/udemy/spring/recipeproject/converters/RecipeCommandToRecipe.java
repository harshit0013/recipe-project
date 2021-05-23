package udemy.spring.recipeproject.converters;

import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import udemy.spring.recipeproject.commands.IngredientCommand;
import udemy.spring.recipeproject.commands.NotesCommand;
import udemy.spring.recipeproject.commands.RecipeCommand;
import udemy.spring.recipeproject.domain.Category;
import udemy.spring.recipeproject.domain.Recipe;

@Component
public class RecipeCommandToRecipe implements Converter<RecipeCommand, Recipe> {
    private final NotesCommandToNotes notes;
    private final IngredientCommandToIngredient ingredient;
    private final CategoryCommandToCategory category;

    public RecipeCommandToRecipe(NotesCommandToNotes notes,
                                 IngredientCommandToIngredient ingredient,
                                 CategoryCommandToCategory category) {
        this.notes = notes;
        this.ingredient = ingredient;
        this.category = category;
    }

    @Synchronized
    @Nullable
    @Override
    public Recipe convert(RecipeCommand source) {
        if(source == null)
            return null;
        final Recipe recipe = new Recipe();
        recipe.setId(source.getId());
        recipe.setSource(source.getSource());
        recipe.setUrl(source.getUrl());
        recipe.setServings(source.getServings());
        recipe.setDirections(source.getDirections());
        recipe.setDifficulty(source.getDifficulty());
        recipe.setDescription(source.getDescription());
        recipe.setPrepTime(source.getPrepTime());
        recipe.setCookTime(source.getCookTime());
        recipe.setNotes(notes.convert(source.getNotes()));

        if(source.getCategories() != null && source.getCategories().size() > 0)
        {
            source.getCategories().forEach(cat -> recipe.getCategories().add(category.convert(cat)));
        }

        if(source.getIngredients() != null && source.getIngredients().size() > 0)
        {
            source.getIngredients().forEach(ingr -> recipe.getIngredients().add(ingredient.convert(ingr)));
        }
        return recipe;
    }
}
