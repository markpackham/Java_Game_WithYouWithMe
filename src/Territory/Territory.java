package Territory;

import Villagers.Villager;

import java.util.List;

// Both kingdoms and farmland are based off a territory
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

    public void setName(String name) {
        this.name = name;
    }

    public List<Villager> getVillagers() {
        return villagers;
    }

    public void setVillagers(List<Villager> villagers) {
        this.villagers = villagers;
    }
}
