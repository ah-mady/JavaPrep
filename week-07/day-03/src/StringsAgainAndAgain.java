public class StringsAgainAndAgain {
  // Given a string, compute recursively a new string where all the adjacent chars are now separated by a *
  public static void main(String[] args) {
    System.out.println(changeXToY("string",1));
  }

  public static String changeXToY(String wordToChange, int index) {
    int indexOfSpace = wordToChange.indexOf(" ");
    if (index == indexOfSpace) {
      return changeXToY(wordToChange, index + 2);
    }
    if (index == wordToChange.length() - 1) {
      return wordToChange.substring(0, index) + "*" + wordToChange.substring(index);
    }
    return changeXToY(wordToChange.substring(0, index) + "*" + wordToChange.substring(index), index + 2);

  }
}
