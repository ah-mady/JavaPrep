package aircraft_carrier;

import java.util.ArrayList;
import java.util.List;

public class Carrier {
  private List<Aircraft> aircraftList;
  private int initialAmmo;
  private int healthPoints;
  private Aircraft aircraft;

  public Carrier(int initialAmmo) {
    this.aircraftList = new ArrayList<>();
    this.initialAmmo = initialAmmo;
    this.healthPoints = 5000;
  }

  public void add(Aircraft aircraft) {
    aircraftList.add(aircraft);
  }

  public void fill() throws Exception {
    if (this.initialAmmo == 0){
      throw new Exception ("Not enough ammo at Carrier");
    } else {
      for (Aircraft jet : aircraftList) {
        if (this.initialAmmo < jet.getMaxAmmo() && jet.isPriority()) {
          this.initialAmmo = jet.refill(this.initialAmmo);
        } else {
          this.initialAmmo = jet.refill(this.initialAmmo);
        }
      }
    }
  }

  public void fight(Carrier enemyCarrier){

  }

  public int getTotalDamage() {
    int totalDamage =0;
    for (Aircraft jet: aircraftList) {
      totalDamage += jet.getBaseDamage() + jet.getCurrentAmmo();
    }
    return totalDamage;
  }

  public String status() {
    if (this.healthPoints <= 0) {
      return "It's dead Jim";
    }
    String report = "HP: " + this.healthPoints + " Aircraft count: " + aircraftList.size() + "Ammo storage: " + this.initialAmmo + "Total damage: "
        + getTotalDamage() +
        System.lineSeparator() + "Aircrafts:";
    for (Aircraft jet : aircraftList) {
      report += System.lineSeparator() + jet.getStatus();
    }
    return report;
  }
}
