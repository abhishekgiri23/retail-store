
package retailstore.discount;

public class CalculateDiscount implements DiscountPolicy {

  @Override
  public double applyDiscount(double totalAmount) {

    if (totalAmount < 100) {
      return totalAmount;
    }

    int discountFactor = (int) totalAmount / 100;
    double discount = (double)discountFactor * 5;
    return totalAmount - discount;
  }

}
