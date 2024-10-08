package Buildings.Farms;

import Buildings.Building;
import java.time.DayOfWeek;
import java.time.LocalDate;

// Belongs to Farmland
public class FarmStable extends Building {

    private int horseNumbers;

    public FarmStable(String buildingName, int buildingYearBuilt, int windows, int doors) {
        super(buildingName, buildingYearBuilt, windows, doors);
        horseNumbers = this.getHorseNumbers();
    }

    // Horse numbers in stable changes based on what day of the week the player plays
    public int getHorseNumbers() {
        DayOfWeek dayOfWeek = LocalDate.now().getDayOfWeek();

        // Demo use of an enhanced switch statement with arrows
        horseNumbers = switch (dayOfWeek) {
            case MONDAY -> 5;
            case TUESDAY -> 6;
            case WEDNESDAY -> 7;
            case THURSDAY -> 8;
            case FRIDAY -> 9;
            case SATURDAY -> 10;
            case SUNDAY -> 11;
        };

        return horseNumbers;
    }
}
