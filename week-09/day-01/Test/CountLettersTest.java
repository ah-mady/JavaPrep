import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CountLettersTest {

  CountLetters countLetters;

  @BeforeEach
  public void setCountLetters(){
    countLetters = new CountLetters();
  }

  @Test
  void countLettersTest() {
    assertEquals(5, countLetters.countLetters("ahmed"));
  }
}