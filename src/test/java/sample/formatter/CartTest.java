package sample.formatter;

import java.math.BigDecimal;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import sample.entity.Amount;
import sample.entity.Item;
import sample.model.Cart;

public class CartTest {
  Cart cart;
  String ID_ITEM_A = "itemA";
  String ID_ITEM_B = "itemB";
  String ID_ITEM_C = "itemC";

  @Before
  public void setUpFormater() {
    cart = new Cart();

    Item itemA = new Item();
    itemA.setItemId(ID_ITEM_A);
    itemA.setListPrice(new Amount(new BigDecimal("5.00")));

    Item itemB = new Item();
    itemB.setItemId(ID_ITEM_B);
    itemB.setListPrice(new Amount(new BigDecimal("10.00")));

    cart.addItem(itemA, true);
    cart.addItem(itemB, true);
  }

  @Test
  public void testSubTotal() {
    Amount subTotal = cart.getSubTotal();
    Assert.assertEquals(new BigDecimal("15.00"), subTotal.getValue());
  }

  @Test
  public void testIncrementQuantityByItemId() {
    cart.incrementQuantityByItemId(ID_ITEM_A);
    cart.incrementQuantityByItemId(ID_ITEM_A);
    cart.incrementQuantityByItemId(ID_ITEM_A);
    cart.incrementQuantityByItemId(ID_ITEM_B);
    cart.incrementQuantityByItemId(ID_ITEM_B);
    Assert.assertEquals(2, cart.getNumberOfItems());
    Assert.assertEquals(4, cart.getCartItem(ID_ITEM_A).getQuantity());
    Assert.assertEquals(3, cart.getCartItem(ID_ITEM_B).getQuantity());
  }

  @Test
  public void testClear() {
    cart.clear();
    Assert.assertEquals(0, cart.getNumberOfItems());
    Assert.assertTrue(cart.isEmpty());
  }

  @Test
  public void testAddItemWithQty() {
    cart.isEmpty();
    Item itemC = new Item();
    itemC.setItemId(ID_ITEM_C);
    itemC.setListPrice(new Amount(new BigDecimal("13.00")));
    cart.addItem(itemC, true);
    cart.setQuantityByItemId(ID_ITEM_C, 10);
    Assert.assertEquals(new BigDecimal("145.00"), cart.getSubTotal().getValue());
    Assert.assertEquals(3, cart.getNumberOfItems());
    Assert.assertEquals(1, cart.getCartItem(ID_ITEM_A).getQuantity());
    Assert.assertEquals(1, cart.getCartItem(ID_ITEM_B).getQuantity());
    Assert.assertEquals(10, cart.getCartItem(ID_ITEM_C).getQuantity());
  }
}
