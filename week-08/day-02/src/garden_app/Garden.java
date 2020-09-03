package garden_app;

import java.util.ArrayList;
import java.util.List;

public class Garden {
  private List<Tree> treeList;
  private List<Flower> flowerList;

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
    for (Flower flower : flowerList) {
      if (!flower.isWatered()) {
        flower.setWaterAmount(waterAmount * flower.getWaterCapacity());
      }
      System.out.println(flower.isWatered() ? "The " + flower.color + " Flower doesn't need water" : "The " + flower.color + " Flower needs water");
    }

    for (Tree tree : treeList) {
      if (!tree.isWatered()) {
        tree.setWaterAmount(waterAmount * tree.getWaterCapacity());
      }
    }

  }

}
