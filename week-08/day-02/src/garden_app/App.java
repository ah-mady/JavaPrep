package garden_app;

public class App {
  public static void main(String[] args) {
    Flower flower = new Flower("Yellow");
    Flower tree = new Flower("purple");

    System.out.println(flower.getWaterAmount());
    Garden garden = new Garden();
    garden.addFlower(flower);
    garden.waterPlants(3);
    System.out.println(flower.getWaterAmount());
  }
}
