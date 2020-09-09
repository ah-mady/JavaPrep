package anagram;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AnagramTest {

  Anagram anagram;

  @BeforeEach
  void setUp() {
    anagram = new Anagram();
  }

  @Test
  void isAnagram_WithNumber_ExpectFalse() {
    assertEquals(false, anagram.isAnagram("car", "123"));
  }

  @Test
  void isAnagram_WithUpperCase_ExpectTrue() {
    assertEquals(true, anagram.isAnagram("LISten", "sIlEnT"));
  }

  @Test
  void isAnagram_WithDifferentLength_ExpectFalse() {
    assertEquals(false, anagram.isAnagram("LISten", "sIlEn"));
  }

  @Test
  void isAnagram_WithOneNullValue_ExpectFalse() {
    assertEquals(false, anagram.isAnagram("LISten", null));
  }

  @Test
  void isAnagram_WithBothNullValues_ExpectFalse() {
    assertEquals(false, anagram.isAnagram(null, null));
  }

  @Test
  void isAnagram_WithSpaceAndNull_ExpectFalse() {
    assertEquals(false, anagram.isAnagram(" ", null));
  }

  @Test
  void isAnagram_WithBothSpaces_ExpectFalse() {
    assertEquals(false, anagram.isAnagram(" ", " "));
  }
}