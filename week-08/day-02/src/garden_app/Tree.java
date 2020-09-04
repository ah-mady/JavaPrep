package garden_app;

public class Tree extends Garden {
  protected TreeColor color;
  private float waterAmount;
  private final float waterCapacity = 0.40f;

  public Tree(TreeColor color) {
    this.color = color;
    this.waterAmount = 0f;
  }

  public boolean isWatered() {
    return waterAmount > 10;
  }

  public float addWater(float waterAmount) {
    return this.waterAmount += waterAmount;
  }

  public float getWaterAmount() {
    return waterAmount;
  }

  public float getWaterCapacity() {
    return waterCapacity;
  }

  public void treeStatus(){
    for (Tree tree: treeList) {
      System.out.println(tree.isWatered() ? "The " + tree.color + " Tree doesn't need water" : "The " + tree.color + " Tree needs water.");
    }
  }
}
