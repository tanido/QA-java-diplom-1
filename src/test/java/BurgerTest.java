import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static junit.framework.TestCase.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    private Bun bun;

    @Mock
    private Ingredient ingredient;

    Burger burger = new Burger();

    @Test
    public void addIngredientTest() {
        burger.addIngredient(ingredient);
        int actual = burger.ingredients.size();
        assertEquals("Неверное количество", 1, actual);
    }

    @Test
    public void removeIngredientTest() {
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        int actual = burger.ingredients.size();
        assertEquals("Неверное количество", 0, actual);
    }

    @Test
    public void moveIngredientTest() {
        Ingredient firstIngredient = new Ingredient(IngredientType.SAUCE, "hot sauce", 100);
        Ingredient secondIngredient = new Ingredient(IngredientType.FILLING, "cutlet", 100);
        burger.addIngredient(firstIngredient);
        burger.addIngredient(secondIngredient);
        burger.moveIngredient(0,1);
        String actual = burger.ingredients.get(1).name;
        assertEquals("Неверный ингредиент", firstIngredient.name, actual);
    }

    @Test
    public void getPriceTest() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        Mockito.when(bun.getPrice()).thenReturn(100F);
        Mockito.when(ingredient.getPrice()).thenReturn(100F);
        float actual = bun.getPrice() * 2 + ingredient.getPrice();
        assertEquals("Неверная цена", burger.getPrice(), actual);
    }

    @Test
    public void getReceiptTest() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        Mockito.when(bun.getName()).thenReturn("black bun");
        Mockito.when(bun.getPrice()).thenReturn(100F);
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredient.getName()).thenReturn("hot sauce");
        Mockito.when(ingredient.getPrice()).thenReturn(100F);
        String expected = "(==== black bun ====)\r\n= sauce hot sauce =\r\n(==== black bun ====)\r\n\r\nPrice: 300,000000\r\n";
        String actual = burger.getReceipt();
        assertEquals("Неверное значение", expected, actual);
    }

}
