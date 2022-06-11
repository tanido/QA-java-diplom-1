import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static junit.framework.TestCase.assertEquals;


public class IngredientTest {
    Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "hot sauce", 100);

    @Test
    public void getPriceTest() {
        float expected = 100;
        float actual = ingredient.getPrice();
        assertEquals("Неверное значение", expected, actual);
    }

    @Test
    public void getNameTest() {
        String expected = "hot sauce";
        String actual = ingredient.getName();
        assertEquals("Неверное значение", expected, actual);
    }

    @Test
    public void getTypeTest() {
        IngredientType expected = IngredientType.SAUCE;
        IngredientType actual = ingredient.getType();
        assertEquals("Неверное значение", expected, actual);
    }
}
