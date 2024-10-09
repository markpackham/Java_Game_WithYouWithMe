package Territory;

import Buildings.Farms.FarmBarn;
import Buildings.Farms.FarmSilo;
import Buildings.Farms.FarmStable;
import Villagers.Villager;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Farmland can host silos with farmers but not have forts with knights and forges with blacksmiths
public class Farmland extends Territory {

    private final Scanner scanner;
    private List<FarmBarn> farmBarns;
    private List<FarmSilo> farmSilos;
    private List<FarmStable> farmStables;

    public Farmland(String name, List<Villager> villagers) {
        super(name, villagers);

        this.scanner = new Scanner(System.in);
        this.farmBarns = new ArrayList<>();
        this.farmSilos = new ArrayList<>();
        this.farmStables = new ArrayList<>();

        initTerritoryFarm();
    }

    private void initTerritoryFarm() {

        // Keep user in loop till they give the territory a name
        while (true) {
            System.out.print("\nName of farmland: ");
            // Use .trim() to remove white space should the user hit space then return
            this.name = scanner.nextLine().trim();
            if (!this.name.isEmpty()) {
                // Only escape when user actually enters something
                break;
            }
            System.out.println("The Farmland name cannot be blank. Please enter a value.");
        }

        // Adding knights (can only be between 0-10) - keep numbers low or you will be typing forever
        // It is possible to have 0 farmers
        int numberofFarmers = -1;
        while (numberofFarmers < 0 || numberofFarmers > 10) {
            System.out.print("How many farmers live in your territory (0-10)?: ");
            try {
                numberofFarmers = Integer.parseInt(scanner.nextLine());
                if (numberofFarmers < 0 || numberofFarmers > 10) {
                    System.out.println("Please enter a number between 0 and 10.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input, you can only have 0 to 10 farmers!");
            }
        }

        // Don't bother creating / populating your farmland if no farmers exist
        if (numberofFarmers > 0) {
            populateTerritoryFarmland(numberofFarmers);
        }

        System.out.println("**********");
        System.out.println("**********");
        System.out.print("\nBarns, Silos & Stable inhabitants of " + this.name + "\n");

    }

    private void populateTerritoryFarmland(int iterations) {

    }

}
