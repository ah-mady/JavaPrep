package flyable;

public class App {
  public static void main(String[] args) {
    Helicopter helicopter = new Helicopter("Heelo");
    Bird bird = new Bird("Eagle");

    helicopter.fly();
    helicopter.land();
    helicopter.takeOff();
    System.out.println();
    bird.breed();
    bird.fly();
    bird.land();
    bird.takeOff();
  }
}
