package udemy.spring.recipeproject.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import udemy.spring.recipeproject.commands.UnitOfMeasureCommand;
import udemy.spring.recipeproject.converters.UnitOfMeasureToUnitOfMeasureCommand;
import udemy.spring.recipeproject.repositories.UnitOfMeasureRepository;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Slf4j
@Service
public class UnitOfMeasureServiceImpl implements UnitOfMeasureService {
    private final UnitOfMeasureRepository repository;
    private final UnitOfMeasureToUnitOfMeasureCommand converter;

    public UnitOfMeasureServiceImpl(UnitOfMeasureRepository repository, UnitOfMeasureToUnitOfMeasureCommand converter) {
        this.repository = repository;
        this.converter = converter;
    }

    @Override
    public Set<UnitOfMeasureCommand> listAllUoms() {
        return StreamSupport.stream(repository.findAll()
        .spliterator(), false)
        .map(converter::convert)
        .collect(Collectors.toSet());
    }
}
