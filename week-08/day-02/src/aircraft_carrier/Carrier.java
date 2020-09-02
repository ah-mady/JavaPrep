package aircraft_carrier;

import java.util.ArrayList;
import java.util.List;

public class Carrier {
  protected List<Aircraft> aircraftList;
  private int initialAmmo;
  private int healthPoints;
  private Aircraft aircraft;

  public Carrier(int initialAmmo, int healthPoints) {
    this.aircraftList = new ArrayList<>();
    this.initialAmmo = initialAmmo;
    this.healthPoints = healthPoints;
  }

  public void add(Aircraft aircraft) {
    aircraftList.add(aircraft);
  }

  public void fill() throws Exception {
    for (Aircraft jet : aircraftList) {
      if (this.initialAmmo > jet.getMaxAmmo() && jet.isPriority()) {
        this.initialAmmo = jet.refill(this.initialAmmo);
      } else if (this.initialAmmo == 0) {
        throw new Exception("Not enough ammo at Carrier");
      }
    }

    for (Aircraft jet : aircraftList) {
      if (this.initialAmmo > jet.getMaxAmmo() && !jet.isPriority()) {
        this.initialAmmo = jet.refill(this.initialAmmo);
      } else if (this.initialAmmo == 0) {
        throw new Exception("Not enough ammo at Carrier");
      }
    }
  }

  //It should take another carrier as a reference parameter and fire all the ammo
  // from the aircrafts to it, then subtract all the damage from its health points

  public void fight(Carrier enemyCarrier) {
    for (Aircraft ourPlane : aircraftList) {
      enemyCarrier.healthPoints -= ourPlane.fight();
    }
    for (Aircraft enemyPlane : enemyCarrier.aircraftList) {
      healthPoints -= enemyPlane.fight();
    }
  }

  public int getTotalDamage() {
    int totalDamage = 0;
    for (Aircraft jet : aircraftList) {
      totalDamage += jet.getBaseDamage() + jet.getCurrentAmmo();
    }
    return totalDamage;
  }

  public String status() {
    if (this.healthPoints <= 0) {
      return "It's dead Jim";
    }
    String report = "HP: " + this.healthPoints + " Aircraft count: " + aircraftList.size() + ". Ammo storage: " + this.initialAmmo + ". Total damage: "
        + getTotalDamage() +
        System.lineSeparator() + "Aircrafts:";
    for (Aircraft jet : aircraftList) {
      report += System.lineSeparator() + jet.getStatus();
    }
    return report;
  }
}
