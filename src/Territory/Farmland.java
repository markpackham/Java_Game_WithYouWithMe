package Territory;

import Buildings.Farms.FarmBarn;
import Buildings.Farms.FarmSilo;
import Buildings.Farms.FarmStable;
import Villagers.Farmer;
import Villagers.Villager;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

// Farmland can host silos with farmers but not have forts with knights and forges with blacksmiths
public class Farmland extends Territory implements ReadIntInput {

    private final Scanner scanner;
    private final List<FarmBarn> farmBarns;
    private final List<FarmSilo> farmSilos;
    private final List<FarmStable> farmStables;

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

        System.out.print("\nAll the barns\n");
        printFarmBarns();
        System.out.println("*****");
        System.out.print("\nAll the farm silos\n");
        printFarmSilos();
        System.out.println("*****");
        System.out.print("\nAll the stables\n");
        printFarmStables();
        System.out.println("*****");
    }

    // Create a farmer then put them with a barn, silo & stable
    private void populateTerritoryFarmland(int iterations) {

        // Force entry of a first name
        for (int i = 0; i < iterations; i++) {
            String fName;
            // Demo use of a do while loop
            do {
                System.out.print("\nEnter farmer first name: ");
                fName = scanner.nextLine();
            } while (fName.trim().isEmpty());

            // Use surname (the family name) instead of last name, more ye-old
            String sName;
            do {
                System.out.print("Enter farmer surname: ");
                sName = scanner.nextLine();
            } while (sName.trim().isEmpty());

            System.out.print("Enter farmer age (must be between 12-100 and defaults to 20): ");
            // If user makes a mistake or enters nothing force the age to be 20
            int age;
            try {
                age = Integer.parseInt(scanner.nextLine());
                if (age < 12 || age > 100) {
                    System.out.println("Age must be between 12-100 and defaults to 20.");
                    age = 20;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Setting default age to 20.");
                age = 20;
            }

            // Create an instance of a farmer
            Farmer farmer = new Farmer(fName, sName, age);
            this.villagers.add(farmer);

            // Allow users to avoid having to add a farmer to a barn if you only want them for a silo or a stable
            System.out.print("\nEnter barn to station farmer at or type 's' to skip: ");
            String barnName = scanner.nextLine();

            if (!barnName.equalsIgnoreCase("s")) {
                // Use the farmland's name and "Barn" if user fails to enter anything
                if (barnName.isEmpty()) {
                    barnName = "Barn " + this.name;
                }

                // Put farmer in a barn, if the barn name already exists we don't need to create a new barn
                FarmBarn farmBarn = findOrCreateFarmBarn(barnName);
                farmBarn.addFarmer(farmer);
            }

            System.out.print("\nEnter silo to station farmer at or type 's' to skip: ");
            String siloName = scanner.nextLine();

            if (!siloName.equalsIgnoreCase("s")) {
                if (siloName.isEmpty()) {
                    siloName = "Silo " + this.name;
                }

                FarmSilo farmSilo = findOrCreateFarmSilo(siloName);
                farmSilo.addFarmer(farmer);
            }

            System.out.print("\nEnter stable to station farmer at or type 's' to skip: ");
            String stableName = scanner.nextLine();

            if (!stableName.equalsIgnoreCase("s")) {
                if (stableName.isEmpty()) {
                    stableName = "Stable " + this.name;
                }

                FarmStable farmStable = findOrCreateFarmStable(stableName);
                farmStable.addFarmer(farmer);
            }

        }

    }

    // Build a barn for a farmer
    private FarmBarn findOrCreateFarmBarn(String barnName) {
        for (FarmBarn barn : farmBarns) {
            if (barn.getBuildingName().equals(barnName)) {
                return barn;
            }
        }

        // Defaults differ for barns, silos and stables
        int buildingYearBuilt = readIntInput("Enter year barn built (enter nothing to use current year): ", Calendar.getInstance().get(Calendar.YEAR));
        int windows = readIntInput("Enter number of windows barn has (default is 2): ", 2);
        int doors = readIntInput("Enter number of doors barn has (default is 1): ", 1);

        // The type of animal the barn stores is selected based on the day of the month it is created
        FarmBarn newFarmBarn = new FarmBarn(barnName, buildingYearBuilt, windows, doors);
        farmBarns.add(newFarmBarn);
        return newFarmBarn;
    }


    // Build a silo for a farmer to store crops in
    private FarmSilo findOrCreateFarmSilo(String siloName) {
        for (FarmSilo silo : farmSilos) {
            if (silo.getBuildingName().equals(siloName)) {
                return silo;
            }
        }

        int buildingYearBuilt = readIntInput("Enter year silo built (enter nothing to use current year): ", Calendar.getInstance().get(Calendar.YEAR));
        int windows = readIntInput("Enter number of windows silo has (default is 1): ", 1);
        int doors = readIntInput("Enter number of doors silo has (default is 1): ", 1);

        FarmSilo newFarmSilo = new FarmSilo(siloName, buildingYearBuilt, windows, doors);
        farmSilos.add(newFarmSilo);
        return newFarmSilo;
    }

    // Build a horse stable to assign the farmer to
    private FarmStable findOrCreateFarmStable(String stableName) {
        for (FarmStable stable : farmStables) {
            if (stable.getBuildingName().equals(stableName)) {
                return stable;
            }
        }

        int buildingYearBuilt = readIntInput("Enter year stable built (enter nothing to use current year): ", Calendar.getInstance().get(Calendar.YEAR));
        int windows = readIntInput("Enter number of windows stable has (default is 1): ", 2);
        int doors = readIntInput("Enter number of doors stable has (default is 1): ", 2);

        FarmStable newFarmStable = new FarmStable(stableName, buildingYearBuilt, windows, doors);
        farmStables.add(newFarmStable);
        return newFarmStable;
    }

    // Read inputs for barns, silos & stables, override interface
    @Override
    public int readIntInput(String prompt, int defaultValue) {
        System.out.print(prompt);
        String input = scanner.nextLine();
        if (!input.isEmpty()) {
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Using default value: " + defaultValue);
            }
        }
        return defaultValue;
    }

    // Output details of the barns
    public void printFarmBarns() {
        for (FarmBarn barn : farmBarns) {
            System.out.println("\nFarm Barn: " + barn.getBuildingName() + ", year built: " + barn.getBuildingYearBuilt() + ", windows: " + barn.getWindows() + ", doors: " + barn.getDoors());
            System.out.println(("The animals held in this barn are " + barn.getAnimals()));
            System.out.println("Farmers");
            System.out.println("______");
            for (Farmer farmer : barn.getFarmers()) {
                farmer.print();
            }
        }
    }

    public void printFarmSilos() {
        for (FarmSilo silo : farmSilos) {
            System.out.println("\nFarm Silo: " + silo.getBuildingName() + ", year built: " + silo.getBuildingYearBuilt() + ", windows: " + silo.getWindows() + ", doors: " + silo.getDoors());
            System.out.println(("The max storage capacity is " + silo.getMaxStorageCapacity() + " tonnes"));
            System.out.println("Farmers");
            System.out.println("______");
            for (Farmer farmer : silo.getFarmers()) {
                farmer.print();
            }
        }
    }

    public void printFarmStables() {
        for (FarmStable stable : farmStables) {
            System.out.println("\nFarm Barns: " + stable.getBuildingName() + ", year built: " + stable.getBuildingYearBuilt() + ", windows: " + stable.getWindows() + ", doors: " + stable.getDoors());
            System.out.println(("Numbers of horses in the stable " + stable.getHorseNumbers()));
            System.out.println("Farmers");
            System.out.println("______");
            for (Farmer farmer : stable.getFarmers()) {
                farmer.print();
            }
        }
    }

}
