package sharpie_set;

import java.util.ArrayList;
import java.util.List;

public class SharpieSet {
  List<Sharpie> setOfSharpie;

  public SharpieSet() {
    setOfSharpie = new ArrayList<>();
  }

  public int countUsable() {
    int count = 0;
    for (Sharpie sharpie : this.setOfSharpie) {
      if (sharpie.getInkAmount() < 0) {
        count++;
      }
    }
    return count;
  }

  public void removeTrash() {
    for (int i = 0; i < this.setOfSharpie.size(); i++) {
      if (this.setOfSharpie.get(i).getInkAmount() <= 0) {
        this.setOfSharpie.remove(i);
        i--;
      }
    }
  }
}
