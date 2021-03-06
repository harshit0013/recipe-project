package udemy.spring.recipeproject.repositories;

import org.springframework.data.repository.CrudRepository;
import udemy.spring.recipeproject.domain.UnitOfMeasure;

import java.util.Optional;

public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasure, Long> {
    Optional<UnitOfMeasure> findByDescription(String description);
}
