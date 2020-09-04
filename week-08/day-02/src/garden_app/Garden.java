package garden_app;

import java.util.ArrayList;
import java.util.List;

public class Garden {
  private List<Tree> treeList;
  protected List<Flower> flowerList;
  private Flower flower;

  public Garden() {
    this.treeList = new ArrayList<>();
    this.flowerList = new ArrayList<>();
  }

  public void addFlower(Flower flower) {
    this.flowerList.add(flower);
  }

  public void addTree(Tree tree) {
    this.treeList.add(tree);
  }

  public void waterPlants() {
    int waterAmount = 40;
    for (Flower flower: flowerList) {
      System.out.println(flower.isWatered() ? "The " + flower.color + " Flower doesn't need water" : "The " + flower.color + " Flower needs water.");
    }

    for (Tree tree: treeList) {
      System.out.println(tree.isWatered() ? "The " + tree.color + " Tree doesn't need water" : "The " + tree.color + " Tree needs water.");
    }
    System.out.println();
    
    System.out.println("Watering with: " + waterAmount);
    for (Flower flower : flowerList) {
      if (!flower.isWatered()) {
        waterAmount -= flower.addWater(waterAmount * flower.getWaterCapacity());
      }
      System.out.println(flower.isWatered() ? "The " + flower.color + " Flower doesn't need water" : "The " + flower.color + " Flower needs water.");
    }

    for (Tree tree : treeList) {
      if (!tree.isWatered()) {
        waterAmount -= tree.addWater(waterAmount * tree.getWaterCapacity());
      }
      System.out.println(tree.isWatered() ? "The " + tree.color + " Tree doesn't need water" : "The " + tree.color + " Tree needs water.");
    }

  }

}
