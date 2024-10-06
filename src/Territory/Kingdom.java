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
        // Change later dummy code
        int buildingYearBuilt;
        // If user enters nothing use current year
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        int windows;
        int doors;


        System.out.print("Enter year fort built (enter nothing to use current year): ");
        try {
            buildingYearBuilt = scanner.nextInt();
        } catch (Exception e) {
            buildingYearBuilt = currentYear;
        }

        System.out.print("Enter number of windows fort has (default is 10): ");
        try {
            windows = scanner.nextInt();
        } catch (Exception e) {
            windows = 10;
        }

        System.out.print("Enter number of doors fort has (default is 2): ");
        try {
            doors = scanner.nextInt();
        } catch (Exception e) {
            doors = 2;
        }

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
            System.out.println("Fort: " + fort.getBuildingName() + ", ID: " + fort.getFortID());
            for (Knight knight : fort.getKnights()) {
                knight.print();
            }
        }
    }
}
