package sample.formatter;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import sample.entity.Inventory;

public class InventoryTest {
  private Inventory inventory;

  @Before
  public void setUpFormater() {
    inventory = new Inventory();
    inventory.setItemId("111111111");
    inventory.setQuantity(42);
  }

  @Test
  public void testInventory() {
    Assert.assertEquals("111111111", inventory.getItemId());
    Assert.assertEquals(42, inventory.getQuantity().intValue());
  }
}
