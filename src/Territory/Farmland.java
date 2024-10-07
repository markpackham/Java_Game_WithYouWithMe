package Territory;

import Villagers.Villager;

import java.util.List;

// Farmland can host silos with farmers but not have forts with knights and forges with blacksmiths
public class Farmland extends Territory {
    public Farmland(String name, List<Villager> villagers) {
        super(name, villagers);
    }
}
