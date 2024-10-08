package Territory;

import Villagers.Blacksmith;
import Villagers.Knight;
import Villagers.Villager;

import java.util.List;

// Might use later if I want every single village printed
public class PopulationPrint {

    List<Villager> villagers;

    // Print ALL Villagers (might use later for future population)
    public void printVillagers() {
        for (Villager v : this.villagers) {
            // Print Knight
            if (v.getClass() == Knight.class) {
                ((Knight) v).print();
            }

            if (v.getClass() == Blacksmith.class) {
                ((Blacksmith) v).print();
            }
        }
    }
}
