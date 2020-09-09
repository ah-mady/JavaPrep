import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

class AnagramTest {

  Anagram anagram;
  String[] words;

  @BeforeEach
  public void setWords(){
    anagram = new Anagram();
  }

  @Test
  void wordsAreAnagram() {
    words = new String[] {"listen", "silent"};
    assertTrue(true, String.valueOf(anagram.isAnagram(words)));
  }

  @Test
  void withOnlyOneWord(){
    words = new String[] {"listen", ""};
    assertTrue(true, String.valueOf(anagram.isAnagram(words)));
  }

  @Test
  void withOnlyOneWord2(){
    words = new String[] {"listen", "silent"};
    assertEquals(true, anagram.isAnagram(words));
  }

  @Test
  void withEmptyList(){
    words = new String[] {"", ""};
    assertEquals(true, anagram.isAnagram(words));
  }

  @Test
  void withBothNullString(){
    words = new String[] {null, null};
    Assertions.assertThrows(NullPointerException.class, () -> anagram.isAnagram(words));
  }

}