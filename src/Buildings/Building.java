package Buildings;

public abstract class Building {
    String buildingName;
    int buildingYearBuilt;
    int windows;
    int doors;

    public Building(String buildingName, int buildingYearBuilt, int windows, int doors) {
        this.buildingName = buildingName;
        this.buildingYearBuilt = buildingYearBuilt;
        this.windows = windows;
        this.doors = doors;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    public int getBuildingYearBuilt() {
        return buildingYearBuilt;
    }

    public void setBuildingYearBuilt(int buildingYearBuilt) {
        this.buildingYearBuilt = buildingYearBuilt;
    }

    public int getWindows() {
        return windows;
    }

    public void setWindows(int windows) {
        this.windows = windows;
    }

    public int getDoors() {
        return doors;
    }

    public void setDoors(int doors) {
        this.doors = doors;
    }
}
