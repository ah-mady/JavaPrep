package sharpie_set;

public class Sharpie {
  static float defaultInkAmount = 100.00f;
  private String color;
  private float width;
  private float inkAmount;

  public Sharpie(String color, float width) {
    this.color = color;
    this.width = width;
    this.inkAmount = defaultInkAmount;
  }

  public float use() {
    this.inkAmount -= 5;
    return inkAmount;
  }

  public float getInkAmount() {
    return inkAmount;
  }

  @Override
  public String toString() {
    return "The " + this.color + " sharpie with " + this.width + " width has " + this.inkAmount + " ink amount left.";
  }
}
