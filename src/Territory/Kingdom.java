package Territory;

import Buildings.Fort;
import Villagers.Knight;
import Villagers.Villager;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

// Villagers and buildings are held in a kingdom
public class Kingdom extends Territory {

    private final Scanner scanner;
    private List<Fort> forts;

    public Kingdom(String name, List<Villager> villagers) {
        super(name, villagers);
        this.scanner = new Scanner(System.in);
        this.forts = new ArrayList<>();
        initTerritory();
    }

    private void initTerritory() {
        System.out.print("\nName of territory: ");
        this.name = scanner.nextLine();
        System.out.print("How many people live in your territory?: ");
        int numberOfVillagers = Integer.parseInt(scanner.nextLine());
        populateTerritory(numberOfVillagers);

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

    // Build fort
    private Fort findOrCreateFort(String fortName) {
        for (Fort fort : forts) {
            if (fort.getBuildingName().equals(fortName)) {
                return fort;
            }
        }
        // If user enters nothing use current year
        int buildingYearBuilt = Calendar.getInstance().get(Calendar.YEAR);
        // Have default values for windows and doors
        int windows = 10;
        int doors = 2;

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
            System.out.println("Fort: " + fort.getBuildingName() + ", ID: " + fort.getFortID() + ", year build: " + fort.getBuildingYearBuilt() + ", windows: " + fort.getWindows() + ", doors: " + fort.getDoors());
            for (Knight knight : fort.getKnights()) {
                knight.print();
            }
        }
    }
}
