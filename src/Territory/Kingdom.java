package Territory;

import Buildings.Kingdoms.BlacksmithSchool;
import Buildings.Kingdoms.Forge;
import Buildings.Kingdoms.Fort;
import Villagers.Blacksmith;
import Villagers.Knight;
import Villagers.Villager;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

// Villagers and buildings are held in a kingdom
// They can have forts with knights and forges with blacksmiths but NOT farmers with silos
public class Kingdom extends Territory implements ReadIntInput {

    private final Scanner scanner;
    private List<Fort> forts;
    private List<Forge> forges;
    private List<BlacksmithSchool> blacksmithSchools;


    public Kingdom(String name, List<Villager> villagers) {
        super(name, villagers);
        this.scanner = new Scanner(System.in);
        this.forts = new ArrayList<>();
        this.forges = new ArrayList<>();
        this.blacksmithSchools = new ArrayList<>();
        initTerritory();
    }

    private void initTerritory() {
        System.out.print("\nName of territory: ");
        this.name = scanner.nextLine();

        // Adding knights
        System.out.print("How many knights live in your territory (0-10)?: ");
        int numberOfKnights = Integer.parseInt(scanner.nextLine());

        if (numberOfKnights > 0) {
            populateTerritoryForts(numberOfKnights);
        }

        // Adding blacksmiths
        System.out.print("\nHow many smiths live in your territory (0-10)?: ");
        int numberOfSmiths = Integer.parseInt(scanner.nextLine());

        if (numberOfSmiths > 0) {
            populateTerritorySmiths(numberOfSmiths);
        }

        System.out.print("\nForts & Forge inhabitants of " + this.name + "\n");

        System.out.print("\nAll the forts\n");
        printForts();
        System.out.print("\nAll the forges\n");
        printForges();
    }

    private void populateTerritoryForts(int iterations) {

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
            // Put a blacksmith with a forge
            Forge forge = findOrCreateForge(forgeName);
            forge.addSmith(blacksmith);

            System.out.print("Enter which schools the smith belongs to: ");
            String blacksmithSchoolName = scanner.nextLine();
            // Associate a blacksmith with a school
            BlacksmithSchool blacksmithSchool = findOrCreateBlacksmithSchool(blacksmithSchoolName);
            blacksmithSchool.addSmith(blacksmith);

        }
    }

    // Build fort
    private Fort findOrCreateFort(String fortName) {
        for (Fort fort : forts) {
            if (fort.getBuildingName().equals(fortName)) {
                return fort;
            }
        }

        int buildingYearBuilt = readIntInput("Enter year forge built (enter nothing to use current year): ", Calendar.getInstance().get(Calendar.YEAR));
        int windows = readIntInput("Enter number of windows forge has (default is 10): ", 10);
        int doors = readIntInput("Enter number of doors forge has (default is 2): ", 2);

        // All forts are given an ID via UUID automatically so this doesn't need to be done here
        Fort newFort = new Fort(fortName, buildingYearBuilt, windows, doors);
        forts.add(newFort);
        return newFort;
    }

    // Build forge
    private Forge findOrCreateForge(String forgeName) {
        for (Forge forge : forges) {
            if (forge.getBuildingName().equals(forgeName)) {
                return forge;
            }
        }

        int buildingYearBuilt = readIntInput("Enter year forge built (enter nothing to use current year): ", Calendar.getInstance().get(Calendar.YEAR));
        int windows = readIntInput("Enter number of windows forge has (default is 10): ", 4);
        int doors = readIntInput("Enter number of doors forge has (default is 2): ", 1);

        Forge newForge = new Forge(forgeName, buildingYearBuilt, windows, doors);
        forges.add(newForge);
        return newForge;
    }

    // Build blacksmith school
    private BlacksmithSchool findOrCreateBlacksmithSchool(String blacksmithSchoolName){
        return null;
    }


    // Read inputs for forge, blacksmith school & fort
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


    public void printVillagers() {
        for (Villager v : this.villagers) {
            // Print Knight
            if (v.getClass() == Knight.class) {
                ((Knight) v).print();
            }

            if (v.getClass() == Blacksmith.class) {
                ((Blacksmith) v).print();
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

    public void printForges() {
        for (Forge forge : forges) {
            System.out.println("\nForge: " + forge.getBuildingName() + ", year built: " + forge.getBuildingYearBuilt() + ", windows: " + forge.getWindows() + ", doors: " + forge.getDoors()
            );

            if (forge.isHasLumberMill()) {
                System.out.println("This forge has a lumber mill!");
            }

            System.out.println("Blacksmiths: ");
            for (Blacksmith blacksmith : forge.getBlacksmiths()) {
                blacksmith.print();
            }
        }
    }
}
