package cloneable;

import java.util.ArrayList;

public class App {
  public static void main(String[] args) {
    ArrayList<Person> people = new ArrayList<>();

    Student john = new Student("John Doe", 20, "male", "BME");
    people.add(john);

    try {
      Student johnCloned = (Student) john.clone();
      johnCloned.setName("JohnTheClone");
      System.out.println(johnCloned.getName());
    } catch (CloneNotSupportedException e) {
      e.printStackTrace();
    }
  }
}
