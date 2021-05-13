package udemy.spring.recipeproject.repositories;

import org.springframework.data.repository.CrudRepository;
import udemy.spring.recipeproject.domain.Recipe;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {
}
