package Buildings.Farms;

import Buildings.Building;

import java.time.LocalDate;

// Belongs to Farmland
public class FarmCattleBarn extends Building {

    String animals;

    public FarmCattleBarn(String buildingName, int buildingYearBuilt, int windows, int doors) {
        super(buildingName, buildingYearBuilt, windows, doors);
    }

    // The animals stored in the barn chosen based on the day of the month
    public String getAnimals() {
        int monthDay = LocalDate.now().getDayOfMonth();

        if (monthDay == 1) {
            animals = "goats";
        }
        // Demo use of modulus, if even animals will be pigs otherwise cows
        else if (monthDay % 2 == 0) {
            animals = "pigs";
        } else {
            animals = "cows";
        }
        return animals;
    }
}
