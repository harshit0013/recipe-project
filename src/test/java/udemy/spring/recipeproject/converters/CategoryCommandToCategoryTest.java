package udemy.spring.recipeproject.converters;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import udemy.spring.recipeproject.commands.CategoryCommand;
import udemy.spring.recipeproject.domain.Category;

import static org.junit.jupiter.api.Assertions.*;

class CategoryCommandToCategoryTest {
    private static final Long ID = new Long(1L);
    private static final String DESCRIPTION = "description";
    CategoryCommandToCategory converter;
    @BeforeEach
    void setUp() {
        converter = new CategoryCommandToCategory();
    }

    @Test
    void testNullObject()
    {
        assertNull(converter.convert(null));
    }

    @Test
    void testEmptyObject()
    {
        assertNotNull(converter.convert(new CategoryCommand()));
    }

    @Test
    void convert() {
        //given
        CategoryCommand category = new CategoryCommand();
        category.setId(ID);
        category.setDescription(DESCRIPTION);

        //when
        Category cat = converter.convert(category);

        //then
        assertEquals(ID, cat.getId());
        assertEquals(DESCRIPTION, cat.getDescription());
    }
}