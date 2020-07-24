public class Swap {
  public static void main(String[] args) {
    // Swap the values of the variables
    int firstNum = 123;
    int secondNum = 526;
    int temp;

    System.out.println("Before swapping,\n\tfirst number is: " + firstNum + "\n\tsecond number is: " + secondNum);

    temp = firstNum;
    firstNum = secondNum;
    secondNum = temp;
    System.out.println();
    System.out.println("After swapping,\n\tfirst number is: " + firstNum + "\n\tsecond number is: " + secondNum);
  }
}
