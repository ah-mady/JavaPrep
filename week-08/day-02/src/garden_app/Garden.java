package garden_app;

import java.util.ArrayList;
import java.util.List;

public class Garden {
  protected List<Tree> treeList;
  protected List<Flower> flowerList;

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

  public void waterPlants(int waterAmount) {
    System.out.println();
    System.out.println("Watering with: " + waterAmount);
    for (Flower flower : flowerList) {
      if (!flower.isWatered()) {
        waterAmount -= flower.addWater(waterAmount * flower.getWaterCapacity());
      }
      flower.flowerStatus();
    }
    for (Tree tree : treeList) {
      if (!tree.isWatered()) {
        waterAmount -= tree.addWater(waterAmount * tree.getWaterCapacity());
      }
      tree.treeStatus();
    }
  }

  public void checkStatus() {
    for (Flower flower : flowerList) {
      flower.flowerStatus();
    }
    for (Tree tree : treeList) {
      tree.treeStatus();
    }
  }
}
