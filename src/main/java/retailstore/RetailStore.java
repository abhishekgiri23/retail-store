
package retailstore;

import retailstore.discount.CalculateDiscount;
import retailstore.discount.DiscountPolicy;
import retailstore.dto.Basket;
import retailstore.dto.Item;
import retailstore.dto.ItemType;
import retailstore.dto.Product;
import retailstore.dto.User;
import retailstore.dto.UserType;

public class RetailStore {

  public static void main(String[] args) {
    User employee = new User(UserType.EMPLOYEE, "Stark");
    Item groceryItem = new Product("Honey", 20, ItemType.GROCERY);
    Item otherItem = new Product("PS5", 990, ItemType.OTHER);
    DiscountPolicy discountPolicy = new CalculateDiscount();

    Basket cart = new Basket(employee, discountPolicy);
    cart.add(groceryItem, 4);
    cart.add(otherItem, 1);
    System.out.println("-----OUTPUT-----");
    System.out.println("********************");
    System.out.println(cart.total());
    System.out.println("********************");

  }
}
