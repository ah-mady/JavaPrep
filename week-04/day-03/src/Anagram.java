import java.util.Arrays;

public class Anagram {
  public static void main(String[] args) {
    System.out.println(isAnagram("green","eergn"));
  }

  private static boolean isAnagram(String string1, String string2) {

    boolean status = true;
    if (string1.length()!=string2.length()){
      status = false;
    } else {
      char[] string1Array = string1.toLowerCase().toCharArray();
      char[] string2Array = string2.toLowerCase().toCharArray();

      Arrays.sort(string1Array);
      Arrays.sort(string2Array);
      status = Arrays.equals(string1Array,string2Array);
    }

    return status;
  }
}
