import java.util.Scanner;

public class HelloUser {
  public static void main(String[] args) {
    // Modify this program to greet user instead of the World!
    // The program should ask for the name of the user

    System.out.println("Please Enter your name: ");
    Scanner scanner = new Scanner(System.in);
    String name = scanner.nextLine();

    System.out.println("Hello " + name + "!");

  }
}
