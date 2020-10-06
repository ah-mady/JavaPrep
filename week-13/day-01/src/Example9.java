public class Example9 {
  public static void main(String[] args) {
    //Write a Stream Expression to find the frequency of characters in a given string!
    String name = "Muhammad Ahmed Abdullah";

    int numberOfOccurrences = (int) name.chars()
        .filter(specificCharToCount -> specificCharToCount == 'a')
        .count();

    System.out.println(numberOfOccurrences);
  }
}
