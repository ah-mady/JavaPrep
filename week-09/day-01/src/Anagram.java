import java.util.Arrays;

public class Anagram {

/*  public static void main(String[] args) {
    String[] words = {"listen" , "silent"};
    System.out.println(isAnagram(words));
  }*/

  public static boolean isAnagram (String[] words){
    String copyOfWord1 = words[0];
    String copyOfWord2 = words[1];

    boolean status = true;

    if (copyOfWord1.length() != copyOfWord2.length()){
      status = false;
    } else {
      char[] wor1Array = copyOfWord1.toLowerCase().toCharArray();
      char [] word2Array = copyOfWord2 .toLowerCase().toCharArray();

      Arrays.sort(wor1Array);
      Arrays.sort(word2Array);
      status = Arrays.equals(wor1Array,word2Array);
    }
    return status;
  }

}
