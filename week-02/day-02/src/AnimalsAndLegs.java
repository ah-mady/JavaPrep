import java.util.Scanner;
import org.w3c.dom.ls.LSOutput;

public class AnimalsAndLegs {
  public static void main(String[] args) {
    // Write a program that asks for two integers
    // The first represents the number of chickens the farmer has
    // The second represents the number of pigs owned by the farmer
    // It should print how many legs all the animals have
    System.out.println("Please enter the number of chickens farmer has: ");
    Scanner myObj = new Scanner(System.in);
    int numberOfChickens = myObj.nextInt();
    int numberOfChickenLegs = numberOfChickens * 2;
    System.out.println("Please enter the number of pigs farmer has: ");
    int numberOfPigs = myObj.nextInt();
    int numberOfPigLegs = numberOfPigs * 4;

    int totalNumberOfLegs = numberOfChickenLegs + numberOfPigLegs;

    System.out.println("Total number of legs of animals in farm house : " + totalNumberOfLegs);

  }
}
