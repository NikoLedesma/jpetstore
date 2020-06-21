package sample.formatter;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import sample.entity.Amount;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Locale;

public class AmountFormatterTest {
  private AmountFormatter amountFormatter;
  private Locale SPANISH_LOCALE ;
  private Locale ENGLISH_LOCALE ;
  @Before
  public void setUpFormater() {
    amountFormatter=new AmountFormatter();
     SPANISH_LOCALE = new Locale( "es", "ES");
     ENGLISH_LOCALE = Locale.ENGLISH;
  }

  @Test
  public void testPrintLocaleEs() {
    Amount amount = new Amount(new BigDecimal("3.25"));
    String numberFormated = amountFormatter.print(amount,SPANISH_LOCALE);
    Assert.assertEquals("$3,25", numberFormated);
  }


  @Test
  public void testPrintLocaleEn() {
    Amount amount = new Amount(new BigDecimal("3.25"));
    String numberFormated = amountFormatter.print(amount,ENGLISH_LOCALE);
    Assert.assertEquals("$3.25", numberFormated);
  }


  @Test
  public void testParseLocaleEs() throws ParseException {
    String text = "$59,25";
    Amount amount =  amountFormatter.parse(text,SPANISH_LOCALE);
    Assert.assertEquals(new BigDecimal("59.25"), amount.getValue());
  }

  @Test
  public void testParseLocaleEn() throws ParseException {
    String text = "$59.25";
    Amount amount =  amountFormatter.parse(text,ENGLISH_LOCALE);
    Assert.assertEquals(new BigDecimal("59.25"), amount.getValue());
  }

  @Test
  public void testParseLocaleEn_MOCK_FAILED() throws ParseException {
    String text = "$59.30";
    Amount amount =  amountFormatter.parse(text,ENGLISH_LOCALE);
    Assert.assertEquals(new BigDecimal("59.25"), amount.getValue());
  }


}
