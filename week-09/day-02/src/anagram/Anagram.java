package anagram;

import java.nio.file.Paths;
import java.util.Arrays;

public class Anagram {

  public static boolean isAnagram(String word1, String word2) {

    if (word1 == null || word2 == null) {
      return false;
    }

    String word1WithNoSpace = word1.replaceAll("\\s", "");
    String word2WithNoSpace = word2.replaceAll("\\s", "");

    if (word1WithNoSpace.length() == 0 || word2WithNoSpace.length() == 0) {
      return false;
    }
    boolean status = true;

    if (word1WithNoSpace.length() != word2WithNoSpace.length()) {
      status = false;
    } else {
      char[] word1Array = word1WithNoSpace.toLowerCase().toCharArray();
      char[] word2Array = word2WithNoSpace.toLowerCase().toCharArray();

      Arrays.sort(word1Array);
      Arrays.sort(word2Array);
      status = Arrays.equals(word1Array, word2Array);
    }
    return status;
  }
}
