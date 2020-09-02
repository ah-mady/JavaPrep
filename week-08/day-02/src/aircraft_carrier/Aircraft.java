package aircraft_carrier;

public class Aircraft {

  private int maxAmmo;
  private int baseDamage;
  private int currentAmmo;
  private int totalDamage;
  private String type;

  public int fight() {
    this.totalDamage = this.baseDamage * this.currentAmmo;
    this.currentAmmo = 0;
    return this.totalDamage;
  }

  public int refill(int refillAmount) {
    if (refillAmount >= this.maxAmmo) {
      this.currentAmmo = this.maxAmmo;
      return refillAmount - this.maxAmmo;
    } else {
      this.currentAmmo += refillAmount;
      return this.currentAmmo;
    }
  }

  public int getMaxAmmo() {
    return maxAmmo;
  }

  public void setMaxAmmo(int maxAmmo) {
    this.maxAmmo = maxAmmo;
  }

  public int getBaseDamage() {
    return baseDamage;
  }

  public void setBaseDamage(int baseDamage) {
    this.baseDamage = baseDamage;
  }

  public int getCurrentAmmo() {
    return currentAmmo;
  }

  public void setCurrentAmmo(int currentAmmo) {
    this.currentAmmo = currentAmmo;
  }

  public String getType() {
    return this.type;
  }

  public String getStatus() {
    return "Type " + getType() + ", Ammo: " + this.getCurrentAmmo() + ", Base Damage: " + this.getBaseDamage()
        + ", All damage: " + fight();
  }

  public boolean isPriority() {
    if (this.getType() == "F35") {
      return true;
    } else {
      return false;
    }
  }
}
