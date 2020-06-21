package sample.formatter;

import java.math.BigDecimal;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import sample.entity.Amount;
import sample.entity.Item;
import sample.model.CartItem;

public class CartItemTest {

  private CartItem cartItem;

  @Before
  public void setUpFormater() {
    cartItem = new CartItem();
    Item item = new Item();
    item.setListPrice(new Amount(new BigDecimal("25.50")));
    cartItem.setItem(item);
    cartItem.setInStock(true);
    cartItem.setQuantity(10);
  }

  @Test
  public void testTotal() {
    Amount totalAmount = cartItem.getTotal();
    Assert.assertEquals(new BigDecimal("255.00"), totalAmount.getValue());
  }

  @Test
  public void testIncrement5Times() {
    cartItem.incrementQuantity();
    cartItem.incrementQuantity();
    cartItem.incrementQuantity();
    cartItem.incrementQuantity();
    cartItem.incrementQuantity();
    Amount totalAmount = cartItem.getTotal();
    Assert.assertEquals(new BigDecimal("382.50"), totalAmount.getValue());
  }
}
