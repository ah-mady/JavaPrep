public class BunniesAgain {
  // We have bunnies standing in a line, numbered 1, 2, ... The odd bunnies (1, 3, ..) have the normal 2 ears.
  // The even bunnies (2, 4, ..) we'll say have 3 ears, because they each have a raised foot.
  // Recursively return the number of "ears" in the bunny line 1, 2, ... n (without loops or multiplication).

  public static int ears;

  public static void main(String[] args) {
    System.out.println(bunnyEarCount(4, ears));
  }

  public static int bunnyEarCount(int bunnies, int ears) {
    if (bunnies == 0) {
      return ears;
    }
    if (bunnies % 2 == 0) {
      return bunnyEarCount(bunnies - 1, ears + 3);
    } else {
      return bunnyEarCount(bunnies - 1, ears + 2);
    }
  }
}
