package udemy.spring.recipeproject.converters;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import udemy.spring.recipeproject.commands.IngredientCommand;
import udemy.spring.recipeproject.commands.UnitOfMeasureCommand;
import udemy.spring.recipeproject.domain.Ingredient;
import udemy.spring.recipeproject.domain.UnitOfMeasure;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class IngredientToIngredientCommandTest {

    public static final BigDecimal AMOUNT = new BigDecimal("2");
    public static final String DESCRIPTION = "description";
    public static final Long ID = new Long(2L);
    public static final Long UOM_ID = new Long(3L);

    IngredientToIngredientCommand converter;

    @BeforeEach
    void setUp() {
        converter = new IngredientToIngredientCommand(new UnitOfMeasureToUnitOfMeasureCommand());
    }

    @Test
    void testNullObject()
    {
        assertNull(converter.convert(null));
    }

    @Test
    void testEmptyObject()
    {
        assertNotNull(converter.convert(new Ingredient()));
    }

    @Test
    void convert() {
        Ingredient ingredient = new Ingredient();
        ingredient.setId(ID);
        ingredient.setDescription(DESCRIPTION);
        ingredient.setAmount(AMOUNT);
        UnitOfMeasure uom = new UnitOfMeasure();
        uom.setId(UOM_ID);
        ingredient.setUom(uom);

        IngredientCommand command = converter.convert(ingredient);

        assertNotNull(command);
        assertNotNull(command.getUom());
        assertEquals(ID, command.getId());
        assertEquals(DESCRIPTION, command.getDescription());
        assertEquals(AMOUNT, command.getAmount());
        assertEquals(UOM_ID, command.getUom().getId());
    }

    @Test
    void convertWithNullUom()
    {
        Ingredient ingredient = new Ingredient();
        ingredient.setId(ID);
        ingredient.setDescription(DESCRIPTION);
        ingredient.setAmount(AMOUNT);

        IngredientCommand command = converter.convert(ingredient);

        assertNotNull(command);
        assertNull(command.getUom());
        assertEquals(ID, command.getId());
        assertEquals(DESCRIPTION, command.getDescription());
        assertEquals(AMOUNT, command.getAmount());
    }
}