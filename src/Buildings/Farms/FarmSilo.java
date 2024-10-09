package Buildings.Farms;

import Buildings.Building;
import Villagers.Farmer;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// Belongs to Farmland
public class FarmSilo extends Building implements AddFarmer {

    // Storage in tonnes, use double for flexibility for crazy large numbers
    private double maxStorageCapacity;
    private final List<Farmer> farmers;

    public FarmSilo(String buildingName, int buildingYearBuilt, int windows, int doors) {
        super(buildingName, buildingYearBuilt, windows, doors);
        generateMaxStorageCapacity();
        this.farmers = new ArrayList<>();
    }

    private void generateMaxStorageCapacity() {
        Random rand = new Random();
        double randomValue = rand.nextDouble(100.55, 120000.55);

        // Convert double to 2 decimal places and round upwards via BigDecimal object
        BigDecimal bigDec = new BigDecimal(randomValue).setScale(2, RoundingMode.CEILING);
        maxStorageCapacity = bigDec.doubleValue();
    }

    public double getMaxStorageCapacity() {
        return maxStorageCapacity;
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
