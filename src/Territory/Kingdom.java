package Territory;

import Buildings.Forge;
import Buildings.Fort;
import Villagers.Blacksmith;
import Villagers.Knight;
import Villagers.Villager;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

// Villagers and buildings are held in a kingdom
// They can have forts with knights and forges with blacksmiths but NOT farmers with silos
public class Kingdom extends Territory {

    private final Scanner scanner;
    private List<Fort> forts;
    private List<Forge> forges;


    // Building defaults
    // If user enters nothing use current year
    int buildingYearBuilt = Calendar.getInstance().get(Calendar.YEAR);
    int windows = 10;
    int doors = 2;


    public Kingdom(String name, List<Villager> villagers) {
        super(name, villagers);
        this.scanner = new Scanner(System.in);
        this.forts = new ArrayList<>();
        this.forges = new ArrayList<>();
        initTerritory();
    }

    private void initTerritory() {
        System.out.print("\nName of territory: ");
        this.name = scanner.nextLine();

        // Adding knights
        System.out.print("How many knights live in your territory?: ");
        int numberOfKnights = Integer.parseInt(scanner.nextLine());
        populateTerritory(numberOfKnights);

        // Adding blacksmiths
        System.out.print("How many smiths live in your territory?: ");
        int numberOfSmiths = Integer.parseInt(scanner.nextLine());
        populateTerritorySmiths(numberOfKnights);

        System.out.print("\nAll the people who live in " + this.name + "\n");
        printVillagers();
        System.out.print("\nAll the forts\n");
        printForts();
    }

    private void populateTerritory(int iterations) {
        for (int i = 0; i < iterations; i++) {
            System.out.print("\nEnter Knight first name: ");
            String fName = scanner.nextLine();
            System.out.print("Enter Knight last name: ");
            String sName = scanner.nextLine();
            System.out.print("Enter Knight age: ");
            int age = Integer.parseInt(scanner.nextLine());
            Knight knight = new Knight(fName, sName, age);
            this.villagers.add(knight);

            System.out.print("Enter Fort to station Knight at: ");
            String fortName = scanner.nextLine();
            // Put Knight in a fort
            Fort fort = findOrCreateFort(fortName);
            fort.addKnight(knight);
        }
    }

    private void populateTerritorySmiths(int iterations) {
        for (int i = 0; i < iterations; i++) {
            System.out.print("\nEnter Blacksmith first name: ");
            String fName = scanner.nextLine();
            System.out.print("Enter Blacksmith last name: ");
            String sName = scanner.nextLine();
            System.out.print("Enter Blacksmith age: ");
            int age = Integer.parseInt(scanner.nextLine());
            Blacksmith blacksmith = new Blacksmith(fName, sName, age);
            this.villagers.add(blacksmith);

            System.out.print("Enter Forge to station smith at: ");
            String forgeName = scanner.nextLine();
            // Put Knight in a fort
            Forge forge = findOrCreateForge(forgeName);
            forge.addSmith(blacksmith);
        }
    }

    // Build forge
    private Forge findOrCreateForge(String forgeName) {

        for (Forge forge : forges) {
            if (forge.getBuildingName().equals(forgeName)) {
                return forge;
            }
        }

        Forge newForge = new Forge(forgeName,buildingYearBuilt, windows, doors);
        forges.add(newForge);
        return newForge;
    }

    // Build fort
    private Fort findOrCreateFort(String fortName) {
        for (Fort fort : forts) {
            if (fort.getBuildingName().equals(fortName)) {
                return fort;
            }
        }

        System.out.print("Enter year fort built (enter nothing to use current year): ");
        String input = scanner.nextLine();
        if (!input.isEmpty()) {
            try {
                buildingYearBuilt = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Using default year: " + buildingYearBuilt);
            }
        }

        System.out.print("Enter number of windows fort has (default is 10): ");
        input = scanner.nextLine();
        if (!input.isEmpty()) {
            try {
                windows = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Using default windows: " + windows);
            }
        }

        System.out.print("Enter number of doors fort has (default is 2): ");
        input = scanner.nextLine();
        if (!input.isEmpty()) {
            try {
                doors = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Using default doors: " + doors);
            }
        }

        // All forts are given an ID via UUID automatically so this doesn't need to be done here
        Fort newFort = new Fort(fortName, buildingYearBuilt, windows, doors);
        forts.add(newFort);
        return newFort;
    }

    public void printVillagers() {
        for (Villager v : this.villagers) {
            // Print Knight
            if (v.getClass() == Knight.class) {
                ((Knight) v).print();
            }
        }
    }

    public void printForts() {
        for (Fort fort : forts) {
            System.out.println("\nFort: " + fort.getBuildingName() + ", ID: " + fort.getFortID() + ", year built: " + fort.getBuildingYearBuilt() + ", windows: " + fort.getWindows() + ", doors: " + fort.getDoors());
            System.out.println("Knights: ");
            for (Knight knight : fort.getKnights()) {
                knight.print();
            }
        }
    }
}
