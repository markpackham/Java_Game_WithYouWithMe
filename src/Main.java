import Territory.Farmland;
import Territory.Kingdom;
import Villagers.Villager;

import java.util.ArrayList;
import java.util.List;

// Entry point for the game
public class Main {
    public static void main(String[] args) {

        // Create an empty list of villagers
        List<Villager> villagers = new ArrayList<>();

        // Kingdom creation
        System.out.println("First please create your kingdom");
        Kingdom kingdom = new Kingdom("", villagers);
        System.out.println("Report on The Kingdom of "+kingdom.getName() + " complete!\n");

        // Farmland creation
//        System.out.println("Now create the farmland to feed this kingdom");
//        Farmland farmland = new Farmland("", villagers);
//        System.out.println("Report on The Farmland of "+farmland.getName() + " complete!\n");

    }
}
