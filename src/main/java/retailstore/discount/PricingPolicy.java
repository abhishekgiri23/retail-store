
package retailstore.discount;

import retailstore.dto.Item;
import retailstore.dto.ItemType;

public class PricingPolicy implements Item {

  private final Item baseItem;

  public PricingPolicy(Item baseItem) {
    this.baseItem = baseItem;
  }

  public double getUnitPrice() {
    return baseItem.getUnitPrice();
  }

  public String getName() {
    return baseItem.getName();
  }

  public ItemType getType() {
    return baseItem.getType();
  }

  public double priceForQuantity(int quantity) {
    return baseItem.priceForQuantity(quantity);
  }
}
