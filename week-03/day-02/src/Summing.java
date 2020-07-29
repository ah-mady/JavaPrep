public class Summing {
  public static void main(String[] args) {
    // Create the usual class wrapper and main method on your own.

// Write a function called `sum` that returns the sum of numbers from zero to the given parameter

    sum(5);

  }
  public static void sum(int number){
    int startingNumber = 0;
    for (int i = 0; i <=number ; i++) {
      startingNumber +=i;
    }
    System.out.println(startingNumber);
  }
}
