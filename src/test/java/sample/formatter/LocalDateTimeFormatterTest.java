package sample.formatter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Locale;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import sample.entity.Amount;

public class LocalDateTimeFormatterTest {

  private LocalDateTimeFormatter localDateTimeFormatter;
  private Locale SPANISH_LOCALE;
  private Locale ENGLISH_LOCALE;

  @Before
  public void setUpFormater() {
    localDateTimeFormatter = new LocalDateTimeFormatter();
    SPANISH_LOCALE = new Locale("es", "ES");
    ENGLISH_LOCALE = Locale.ENGLISH;
  }

  @Test
  public void testPrintLocaleEs() {
    Amount amount = new Amount(new BigDecimal("3.25"));
    LocalDateTime temporal = LocalDateTime.of(2017, 1, 14, 10, 34);
    String text = localDateTimeFormatter.print(temporal, SPANISH_LOCALE);
    Assert.assertEquals("2017-01-14 10:34:00", text);
  }

  @Test
  public void testPrintLocaleEn() {
    Amount amount = new Amount(new BigDecimal("3.25"));
    LocalDateTime temporal = LocalDateTime.of(2020, 12, 14, 23, 59);
    String text = localDateTimeFormatter.print(temporal, ENGLISH_LOCALE);
    Assert.assertEquals("2020-12-14 23:59:00", text);
  }

  @Test
  public void testParseLocaleEs() {
    LocalDateTime temporal = LocalDateTime.of(2020, 12, 14, 23, 59);
    LocalDateTime localDateTimeParsed =
        localDateTimeFormatter.parse("2020-12-14T23:59:00", SPANISH_LOCALE);
    Assert.assertTrue(localDateTimeParsed.compareTo(temporal) == 0);
  }

  @Test
  public void testParseLocaleEn() {
    LocalDateTime temporal = LocalDateTime.of(2019, 6, 27, 12, 25);
    LocalDateTime localDateTimeParsed =
        localDateTimeFormatter.parse("2019-06-27T12:25:00", ENGLISH_LOCALE);
    Assert.assertTrue(localDateTimeParsed.compareTo(temporal) == 0);
  }

  @Test
  public void testParseLocaleEsNotEq() {
    LocalDateTime temporal = LocalDateTime.of(2012, 12, 14, 23, 59);
    LocalDateTime localDateTimeParsed =
        localDateTimeFormatter.parse("2020-12-14T23:59:00", SPANISH_LOCALE);
    Assert.assertTrue(localDateTimeParsed.compareTo(temporal) > 0);
  }
}
