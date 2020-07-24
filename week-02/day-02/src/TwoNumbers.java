public class TwoNumbers {
  public static void main(String[] args) {
    // Create a program that prints a few operations on two numbers: 22 and 13
    // Print the result of 13 added to 22
    // Print the result of 13 substracted from 22
    // Print the result of 22 multiplied by 13
    // Print the result of 22 divided by 13 (as a decimal fraction)
    // Print the integer part of 22 divided by 13
    // Print the remainder of 22 divided by 13


    int firstNum = 22;
    int secondNum = 13;

    int additionResult = firstNum + secondNum;
    int subtractionResult = secondNum - firstNum;
    int multiplicationResult = firstNum * secondNum;
    float divisionResultWithDecimal = (float)firstNum / (float)secondNum;
    int divisionResult = firstNum / secondNum;
    double remainderResult = firstNum % secondNum;

    System.out.println("Adding both numbers= " + additionResult);
    System.out.println("Subtracting both number: " + subtractionResult);
    System.out.println("Multiplying both number: " + multiplicationResult);
    System.out.println("Division result with decimals: " + divisionResultWithDecimal);
    System.out.println("Dividing both numbers: " + divisionResult);
    System.out.println("Remainder of both numbers: " + remainderResult);

  }
}
