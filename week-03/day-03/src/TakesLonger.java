public class TakesLonger {
  public static void main(String[] args) {
    String quote = "Hofstadter's Law: It you expect, even when you take into account Hofstadter's Law.";

    // When saving this quote a disk error has occurred. Please fix it.
    // Add "always takes longer than" to the StringBuilder (quote) between the words "It" and "you"
    // Using pieces of the quote variable (instead of just redefining the string)

    fixedQuote(quote);
  }

  private static void fixedQuote(String quote) {
    StringBuilder fixedQuotes = new StringBuilder(quote);
    int toIndex = quote.indexOf("you");
    String toAdd = "always takes longer than ";
    System.out.println(fixedQuotes.substring(0, toIndex) + toAdd + fixedQuotes.substring(toIndex));
  }
}
