package Territory;

import Villagers.Villager;

import java.util.List;

public class Territory {

    // Use protected so child classes can access
    protected String name;
    protected List<Villager> villagers;

    public Territory(String name, List<Villager> villagers) {
        this.name = name;
        this.villagers = villagers;
    }

    public String getName() {
        return name;
    }

    public List<Villager> getVillagers() {
        return villagers;
    }
}
