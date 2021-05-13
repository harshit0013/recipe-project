package udemy.spring.recipeproject.repositories;

import org.springframework.data.repository.CrudRepository;
import udemy.spring.recipeproject.domain.Category;

public interface CategoryRepository extends CrudRepository<Category, Long> {
}
