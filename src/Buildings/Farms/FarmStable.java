package Buildings.Farms;

import Buildings.Building;
import Villagers.Farmer;
import Villagers.Knight;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

// Belongs to Farmland
public class FarmStable extends Building implements AddFarmer{

    private int horseNumbers;
    private final List<Farmer> farmers;

    public FarmStable(String buildingName, int buildingYearBuilt, int windows, int doors) {
        super(buildingName, buildingYearBuilt, windows, doors);
        horseNumbers = this.getHorseNumbers();
        this.farmers = new ArrayList<>();
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

    @Override
    public void addFarmer(Farmer farmer) {
        this.farmers.add(farmer);
    }

    @Override
    public List<Farmer> getFarmers() {
        return farmers;
    }
}
