public class CountLetters {

  public static int countLetters(String word){
    int count = 0;
    char[] stringToCharArray = word.toCharArray();
    for (char character: stringToCharArray) {
      count++;
    }
    return count;
  }
}
