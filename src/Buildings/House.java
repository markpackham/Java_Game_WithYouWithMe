package Buildings;

import java.util.UUID;

public class House extends Building{

    private final String houseID;

    public House(String buildingName, int buildingYearBuilt, int windows, int doors) {
        super(buildingName, buildingYearBuilt, windows, doors);

        // All houses are given a unique ID
        UUID uuid = UUID.randomUUID();
        houseID = uuid.toString();
    }

    public String getHouseID() {
        return houseID;
    }
}
