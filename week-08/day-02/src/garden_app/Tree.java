package garden_app;

public class Tree extends Garden{
  private String color;
  private float waterAmount;
  private final float waterCapacity = 0.40f;

  public Tree(String color) {
    this.color = color;
    this.waterAmount = 0f;
  }

  public boolean isWatered(){
    return waterAmount < 10;
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
