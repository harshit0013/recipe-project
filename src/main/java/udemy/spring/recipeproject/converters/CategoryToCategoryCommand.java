package udemy.spring.recipeproject.converters;

import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import udemy.spring.recipeproject.commands.CategoryCommand;
import udemy.spring.recipeproject.domain.Category;

@Component
public class CategoryToCategoryCommand implements Converter<Category, CategoryCommand> {
    @Synchronized
    @Nullable
    @Override
    public CategoryCommand convert(Category source) {
        if(source == null)
            return null;
        final CategoryCommand categoryCommand = new CategoryCommand();
        categoryCommand.setId(source.getId());
        categoryCommand.setDescription(source.getDescription());
        return categoryCommand;
    }
}
