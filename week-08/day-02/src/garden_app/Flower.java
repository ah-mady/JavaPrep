package garden_app;

public class Flower extends Garden {
  protected String color;
  private float waterAmount;
  private final float waterCapacity = 0.75f;
  private boolean isWatered;

  public Flower(String color) {
    this.color = color;
    this.waterAmount = 0f;
    this.isWatered = false;
  }

  public boolean isWatered(){
    if (this.waterAmount < 5){
      this.isWatered = true;
    } else {
      this.isWatered = false;
    }
    return this.isWatered;
  }

  public void addWater(int waterAmount){
    this.waterAmount += waterAmount;
  }

  public float getWaterAmount() {
    return waterAmount;
  }

  public void setWaterAmount(float waterAmount) {
    this.waterAmount = waterAmount;
  }

  public float getWaterCapacity() {
    return waterCapacity;
  }
}
