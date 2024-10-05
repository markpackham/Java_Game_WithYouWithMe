package Buildings;

import Villagers.Knight;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Fort extends Building {

    private final String fortID;
    private List<Knight> knights;

    public Fort(String buildingName, int buildingYearBuilt, int windows, int doors) {
        super(buildingName, buildingYearBuilt, windows, doors);
        this.fortID = UUID.randomUUID().toString();
        this.knights = new ArrayList<>();
    }

    public String getFortID() {
        return fortID;
    }

    public void addKnight(Knight knight) {
        this.knights.add(knight);
    }

    public List<Knight> getKnights() {
        return knights;
    }
}
