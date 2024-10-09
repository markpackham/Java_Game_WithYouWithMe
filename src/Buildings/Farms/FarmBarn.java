package Buildings.Farms;

import Buildings.Building;
import Villagers.Farmer;
import Villagers.Knight;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

// Belongs to Farmland
public class FarmBarn extends Building implements AddFarmer {

    String animals;
    private final List<Farmer> farmers;

    public FarmBarn(String buildingName, int buildingYearBuilt, int windows, int doors) {
        super(buildingName, buildingYearBuilt, windows, doors);
        animals = this.getAnimals();
        this.farmers = new ArrayList<>();
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

    @Override
    public void addFarmer(Farmer farmer) {
        this.farmers.add(farmer);
    }

    @Override
    public List<Farmer> getFarmers() {
        return farmers;
    }
}
