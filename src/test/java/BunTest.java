import org.junit.Test;
import praktikum.Bun;

import static junit.framework.TestCase.assertEquals;

public class BunTest {
    String name = "black bun";
    float price = 100;
    Bun bun = new Bun(name, price);


    @Test
    public void getNameTest() {
        String actual = bun.getName();
        assertEquals("Неверное имя", name, actual);
    }

    @Test
    public void getPriceTest() {
        float actual = bun.getPrice();
        assertEquals("Неверная цена", price, actual);
    }
}
