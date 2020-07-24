import java.text.DecimalFormat;

public class Bmi {
  public static void main(String[] args) {
    double massInKg = 81.2;
    double heightInM = 1.78;

    // Print the Body mass index (BMI) based on these values
    double bodyMassIndex = massInKg / (heightInM*heightInM);
    DecimalFormat formatter = new DecimalFormat("0.00");
    System.out.println("BMI is: " + formatter.format(bodyMassIndex));
  }
}
