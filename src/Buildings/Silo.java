package Buildings;

public class Silo extends Building{

    // Storage in tonnes with a default of 120.5
    private double maxStorageCapacity = 120.5;

    public Silo(String buildingName, int buildingYearBuilt, int windows, int doors, double maxStorageCapacity) {
        super(buildingName, buildingYearBuilt, windows, doors);
        this.maxStorageCapacity = maxStorageCapacity;
    }

    public double getMaxStorageCapacity() {
        return maxStorageCapacity;
    }
}
