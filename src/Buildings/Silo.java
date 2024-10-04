package Buildings;

import Villagers.Farmer;

import java.util.ArrayList;
import java.util.List;

public class Silo extends Building {

    // Storage in tonnes with a default of 120000.55, use double for flexibility for crazy large numbers
    private double maxStorageCapacity = 120000.55;

    private List<Farmer> farmers;

    public Silo(String buildingName, int buildingYearBuilt, int windows, int doors, double maxStorageCapacity) {
        super(buildingName, buildingYearBuilt, windows, doors);
        this.maxStorageCapacity = maxStorageCapacity;
        this.farmers = new ArrayList<>();
    }

    public double getMaxStorageCapacity() {
        return maxStorageCapacity;
    }

    public List<Farmer> getFarmers() {
        return farmers;
    }
}
