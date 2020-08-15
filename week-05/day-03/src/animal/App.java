package animal;

public class App {
  public static void main(String[] args) {
    Animal animal1 = new Animal("Cini");

    animal1.play();

    System.out.println(animal1);

    animal1.drink();
    animal1.drink();
    animal1.drink();
    animal1.eat();
    animal1.eat();
    animal1.eat();
    System.out.println(animal1);
  }
}
