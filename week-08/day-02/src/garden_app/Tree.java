package garden_app;

public class Tree {
  protected TreeColor color;
  private float waterAmount;
  private final float waterCapacity = 0.40f;
  private boolean isWatered;

  public Tree(TreeColor color) {
    this.color = color;
    this.waterAmount = 0f;
    this.isWatered = false;
  }

  public boolean isWatered() {
    return waterAmount > 10;
  }

  public float addWater(float waterAmount) {
    return this.waterAmount += waterAmount;
  }

  public float getWaterCapacity() {
    return waterCapacity;
  }

  public void treeStatus() {
    System.out.println(this.isWatered() ? "The " + this.color + " Tree doesn't need water" : "The " + this.color + " Tree needs water.");
  }
}
