package udemy.spring.recipeproject.repositories;

import org.springframework.data.repository.CrudRepository;
import udemy.spring.recipeproject.domain.UnitOfMeasure;

public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasure, Long> {
}
