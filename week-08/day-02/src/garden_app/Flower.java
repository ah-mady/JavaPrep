package garden_app;

public class Flower extends Garden {
  protected String color;
  private float waterAmount;
  private final float waterCapacity = 0.75f;

  public Flower(String color) {
    this.color = color;
    this.waterAmount = 0f;
  }

  public boolean isWatered(){
    return waterAmount < 5;
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
