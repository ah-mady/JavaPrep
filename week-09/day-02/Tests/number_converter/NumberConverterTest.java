package number_converter;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class NumberConverterTest {

  NumberConverter numberConverter;

  @BeforeEach
  void setUp() {
    numberConverter = new NumberConverter();
  }

  @Test
  void convertWithNegative_ExpectInvalidString() {
    assertEquals("Invalid balance!", numberConverter.convert(-1));
  }

  @Test
  void convertWithZero_ExpectInvalidString() {
    assertEquals("Invalid balance!", numberConverter.convert(0));
  }

  @Test
  void convertWithOne_ExpectOne() {
    assertEquals("one", numberConverter.convert(1));
  }

  @Test
  void convertWithMaxInteger_ExpectCorrectString() {
    assertEquals("two billion one hundred forty seven million four " +
        "hundred eighty three thousand six hundred forty seven", numberConverter.convert(Integer.MAX_VALUE));
  }

  @Test
  void convertWithMaxIntegerPlus1_ExpectInvalidString() {
    assertEquals("Invalid balance!", numberConverter.convert(Integer.MAX_VALUE + 1));
  }
}