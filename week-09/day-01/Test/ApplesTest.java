import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ApplesTest {
  Apples apples;

  @BeforeEach
  public void setup() {
    apples = new Apples();
  }

  @Test
  void returnAppleTest() {
    assertEquals("apple", apples.getApple());
  }
}