public class DivideByZero {
  public static void main(String[] args) {
    // Create a function that takes a number
// divides ten with it,
// and prints the result.
// It should print "fail" if the parameter is 0

    divideByTen(30);
  }

  private static void divideByTen(int i) {
    try {
      System.out.println(division(i));
    } catch (ArithmeticException e){
      System.out.println("fail");
    }
  }
  public static int division(int number){
    int dividend = 10;
    return dividend / number;
  }
}
