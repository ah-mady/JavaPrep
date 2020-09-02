package aircraft_carrier;

public class App {
  public static void main(String[] args) throws Exception {
    Aircraft jet1 = new F16();
    Aircraft jet2 = new F35();

    //jet1.refill(100);

    Carrier carr = new Carrier(1000, 6000);
    Carrier carr2 = new Carrier(2000,1000);


    carr.add(jet1);
    carr.add(jet2);

    carr2.add(jet1);
    carr2.add(jet2);

    carr.fill();
    carr2.fill();

    //System.out.println(carr.aircraftList.get(0).getStatus());
    //System.out.println(carr.aircraftList.get(1).getStatus());
    // System.out.println(carr.initialAmmo);

    //carr.fight(carr2);
    carr2.fight(carr);

    //System.out.println(carr.aircraftList.get(0).getStatus());
    //System.out.println(carr.aircraftList.get(1).getStatus());
    System.out.println(carr.status());
    System.out.println();
    System.out.println(carr2.status());
  }
}
