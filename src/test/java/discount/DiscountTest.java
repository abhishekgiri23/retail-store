package discount;

import org.junit.Before;
import org.junit.Test;
import retailstore.discount.CalculateDiscount;
import retailstore.discount.DiscountPolicy;
import retailstore.dto.Basket;
import retailstore.dto.Item;
import retailstore.dto.ItemType;
import retailstore.dto.Product;
import retailstore.dto.User;
import retailstore.dto.UserType;

import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;

public class DiscountTest {
    private Item groceryItem;
    private Item otherItem;
    private User employee;
    private User affiliate;
    private User simpleUser;
    private User simpleUserWith2Years;
    private DiscountPolicy discountPolicy;

    @Before
    public void setUp() {
        employee = new User(UserType.EMPLOYEE, "Stark");
        affiliate = new User(UserType.AFFILIATE, "Evan");
        simpleUser = new User(UserType.REGULAR, "Amanda");
        simpleUserWith2Years = new User(UserType.REGULAR, "Lyndon", LocalDateTime.of(2018, 7, 19, 6, 40, 45));
        groceryItem = new Product("Honey", 20, ItemType.GROCERY);
        otherItem = new Product("PS5", 222, ItemType.OTHER);
        discountPolicy = new CalculateDiscount();
    }

    @Test
    public void EmployeeWithGroceryTest() {
        Basket basket = new Basket(employee, discountPolicy);
        basket.add(groceryItem, 4);
        // No discount because of grocery item
        assertEquals(80, basket.total(), 0.01);

    }

    @Test
    public void EmployeeWithOtherItemTest() {
        Basket basket = new Basket(employee, discountPolicy);
        basket.add(otherItem, 4);
        assertEquals(591.6, basket.total(), 0.01);

    }

    @Test
    public void test_affiliateWithGrocery() {
        Basket basket = new Basket(affiliate, discountPolicy);
        basket.add(groceryItem, 4);
        assertEquals(80, basket.total(), 0.01);

    }

    @Test
    public void AffiliateWithOtherItemTest() {
        Basket basket = new Basket(affiliate, discountPolicy);
        basket.add(otherItem, 4);
        assertEquals(764.2, basket.total(), 0.01);

    }

    @Test
    public void SimpleUserWithGroceryTest() {
        Basket basket = new Basket(simpleUser, discountPolicy);
        basket.add(groceryItem, 4);
        assertEquals(80, basket.total(), 0.01);

    }

    @Test
    public void SimpleUserWithOtherItemTest() {
        Basket basket = new Basket(simpleUser, discountPolicy);
        basket.add(otherItem, 4);
        assertEquals(848, basket.total(), 0.01);
    }

    @Test
    public void SimpleUserWith2YearsWithGroceryTest() {
        Basket basket = new Basket(simpleUserWith2Years, discountPolicy);
        basket.add(groceryItem, 4);
        assertEquals(80, basket.total(), 0.01);

    }

    @Test
    public void test_simpleUserWith2YearsWithOtherItem() {
        Basket basket = new Basket(simpleUserWith2Years, discountPolicy);
        basket.add(otherItem, 4);
        assertEquals(803.6, basket.total(), 0.01);

    }

    @Test
    public void EmployeeWithGroceryAndOtherItemTest() {
        Basket basket = new Basket(employee, discountPolicy);
        basket.add(groceryItem, 4);
        basket.add(otherItem, 4);
        assertEquals(666.6, basket.total(), 0.01);

    }
}
