import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static junit.framework.TestCase.assertEquals;

@RunWith(Parameterized.class)
public class IngredientTypeParametersTest {

    private IngredientType type;

    public  IngredientTypeParametersTest(IngredientType type) {
        this.type = type;
    }

    @Parameterized.Parameters
    public static Object[][] getIngredientType() {
        return new Object[][] {
                {IngredientType.SAUCE},
                {IngredientType.FILLING}
        };
    }

    @Test
    public void ingredientTypeTest() {
        Ingredient ingredient = new Ingredient(type, "hot sauce", 100);
        IngredientType actual = ingredient.getType();
        assertEquals("Неверный тип", type, actual);
    }

}
