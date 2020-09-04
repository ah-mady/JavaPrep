package garden_app;

public class Flower {
  protected FlowerColor color;
  private float waterAmount;
  private final float waterCapacity = 0.75f;
  private boolean isWatered;

  public Flower(FlowerColor flowerColor) {
    this.color = flowerColor;
    this.waterAmount = 0f;
    this.isWatered = false;
  }

  public boolean isWatered() {
    return waterAmount > 5;
  }

  public float addWater(float waterAmount) {
    return this.waterAmount += waterAmount;
  }

  public float getWaterCapacity() {
    return waterCapacity;
  }

  public void flowerStatus() {
    System.out.println(this.isWatered() ? "The " + this.color + " Flower doesn't need water" : "The " + this.color + " Flower needs water.");
  }
}
