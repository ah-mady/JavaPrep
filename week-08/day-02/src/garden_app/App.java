package garden_app;

public class App {
  public static void main(String[] args) {

    Garden garden = new Garden();

    Flower flower = new Flower(FlowerColor.blue);
    Flower flower2 = new Flower(FlowerColor.yellow);
    Tree tree = new Tree(TreeColor.orange);
    Tree tree2 = new Tree(TreeColor.purple);

    garden.addFlower(flower);
    garden.addFlower(flower2);
    garden.addTree(tree);
    garden.addTree(tree2);

    garden.waterPlants();
    System.out.println();
    garden.waterPlants();

  }
}
