package Buildings;

import Villagers.Blacksmith;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Forge extends Building {

    // Boolean to see whether a lumber mill is attached to the forge
    private final boolean hasLumberMill;
    // Forge will hold blacksmiths
    private List<Blacksmith> blacksmiths;

    public Forge(String buildingName, int buildingYearBuilt, int windows, int doors) {
        super(buildingName, buildingYearBuilt, windows, doors);

        // Random result if forge also has a lumber mill next to it for fuel
        this.hasLumberMill = new Random().nextBoolean();
        this.blacksmiths = new ArrayList<>();
    }

    public boolean isHasLumberMill() {
        return hasLumberMill;
    }

    public List<Blacksmith> getBlacksmiths() {
        return blacksmiths;
    }
}
