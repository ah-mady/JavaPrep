import java.text.DecimalFormat;
import java.util.Scanner;

public class MileToKmConverter {
  public static void main(String[] args) {
    // Write a program that asks for a double that is a distance in miles,
    // then it converts that value to kilometers and prints it
    System.out.println("Please enter the distance in miles: ");
    Scanner myObj = new Scanner(System.in);
    double distanceInMiles = myObj.nextDouble();

    double distanceInKm = distanceInMiles * 1.609;
    DecimalFormat formatter = new DecimalFormat("0.00");

    System.out.println("Your distance in KM is: " + formatter.format(distanceInKm));
  }
}
