package sharpie;

public class App {
  public static void main(String[] args) {
    Sharpie sharpie = new Sharpie("blue", 2.5f);
    System.out.println(sharpie);
    sharpie.use();
    System.out.println(sharpie);
  }
}
