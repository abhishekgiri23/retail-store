package discount;

import org.junit.Before;
import org.junit.Test;
import retailstore.dto.Basket;
import retailstore.dto.Item;
import retailstore.dto.ItemType;
import retailstore.dto.Product;
import retailstore.dto.User;
import retailstore.dto.UserType;

import static org.junit.Assert.assertEquals;

public class BasketTest {
    private Basket basket;
    private Item item;

    @Before
    public void setUp() {
        User user = new User(UserType.SIMPLE, "Stark");
        basket = new Basket(user);
        item = new Product("something", 1000, ItemType.OTHER);
    }

    @Test
    public void EmptyCartCostsZeroTest() {
        assertEquals(0, basket.total(), 0.01);
    }

    @Test
    public void SingleBasicItemCostsItsUnitPriceTest() {
        basket.add(item,1);
        assertEquals(item.getUnitPrice(), basket.total(), 0.01);
    }

    @Test
    public void MultipleBasicItemsCostProportionallyTest() {
        int howMany = 3;
        basket.add(item, howMany);
        assertEquals(howMany * item.getUnitPrice(), basket.total(), 0.01);
    }

    @Test
    public void SeparatelyAddingTest() {
        int howMany = 3;
        for (int i = howMany; i > 0; i--) {
            basket.add(item,1);
        }
        assertEquals(howMany * item.getUnitPrice(), basket.total(), 0.01);
    }
}
