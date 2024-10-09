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

// Knights & blacksmiths are held in a kingdom
// They can have forts with knights, blacksmith schools & forges with blacksmiths but NOT farmers with silos, stables or barns
public class Kingdom extends Territory implements ReadIntInput {

    private final Scanner scanner;
    private final List<Fort> forts;
    private final List<Forge> forges;
    private final List<BlacksmithSchool> blacksmithSchools;

    // Constructor
    public Kingdom(String name, List<Villager> villagers) {
        super(name, villagers);
        this.scanner = new Scanner(System.in);
        // Use ArrayLists to hold forts, forges & schools since we can't predict how many the user will create
        this.forts = new ArrayList<>();
        this.forges = new ArrayList<>();
        this.blacksmithSchools = new ArrayList<>();
        initTerritory();
    }

    // Populate kingdom with villagers & buildings
    private void initTerritory() {

        // Keep user in loop till they give the territory a name
        while (true) {
            System.out.print("\nName of kingdom: ");
            // Use .trim() to remove white space should the user hit space then return
            this.name = scanner.nextLine().trim();
            if (!this.name.isEmpty()) {
                // Only escape when user actually enters something
                break;
            }
            System.out.println("Kingdom name cannot be blank. Please enter a value.");
        }


        // Adding knights (can only be between 0-10) - keep numbers low or you will be typing forever
        // It is possible to have 0 knights if you instead just want to make blacksmiths
        int numberOfKnights = -1;
        while (numberOfKnights < 0 || numberOfKnights > 10) {
            System.out.print("How many knights live in your territory (0-10)?: ");
            try {
                numberOfKnights = Integer.parseInt(scanner.nextLine());
                if (numberOfKnights < 0 || numberOfKnights > 10) {
                    System.out.println("Please enter a number between 0 and 10.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input, you can only have 0 to 10 knights!");
            }
        }

        // Don't bother creating / populating your forts if no knights exist
        if (numberOfKnights > 0) {
            populateTerritoryForts(numberOfKnights);
        }

        // Adding blacksmiths (can only be between 0-10)
        int numberOfSmiths = -1;
        while (numberOfSmiths < 0 || numberOfSmiths > 10) {
            System.out.print("\nHow many smiths live in your territory (0-10)?: ");
            try {
                numberOfSmiths = Integer.parseInt(scanner.nextLine());
                if (numberOfSmiths < 0 || numberOfSmiths > 10) {
                    System.out.println("Please enter a number between 0 and 10.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input, you can only have 0 to 10 blacksmiths!");
            }
        }

        // Don't bother populating forges or schools if no blacksmiths exist
        if (numberOfSmiths > 0) {
            populateTerritorySmiths(numberOfSmiths);
        }

        System.out.println("**********");
        System.out.println("**********");
        System.out.print("\nForts, Forges & Blacksmith School inhabitants of " + this.name + "\n");

        System.out.print("\nAll the forts\n");
        printForts();
        System.out.println("*****");
        System.out.print("\nAll the forges\n");
        printForges();
        System.out.println("*****");
        System.out.print("\nAll the blacksmith schools\n");
        printBlacksmithSchools();
        System.out.println("*****");
    }

    // Create a knight then create a fort for it to be added to
    private void populateTerritoryForts(int iterations) {

        // Force entry of a first name
        for (int i = 0; i < iterations; i++) {
            String fName;
            // Demo use of a do while loop
            do {
                System.out.print("\nEnter first name: ");
                fName = scanner.nextLine();
            } while (fName.trim().isEmpty());

            // Use surname (the family name) instead of last name, more ye-old
            String sName;
            do {
                System.out.print("Enter surname: ");
                sName = scanner.nextLine();
            } while (sName.trim().isEmpty());

            System.out.print("Enter age (must be between 12-100 and defaults to 20): ");
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

            // Create an instance of a knight
            Knight knight = new Knight(fName, sName, age);
            this.villagers.add(knight);

            System.out.print("\nEnter fort to station knight at: ");
            String fortName = scanner.nextLine();

            // Use the Kingdom's name and "Fort" if user fails to enter anything
            if (fortName.isEmpty()) {
                fortName = "Fort " + this.name;
            }

            // Put knight in a fort, if the fort name already exists we don't need to create a new fort
            Fort fort = findOrCreateFort(fortName);
            fort.addKnight(knight);
        }
    }


    // Create blacksmiths then create forges and schools for them to be added to
    private void populateTerritorySmiths(int iterations) {

        // Force entry of a first name
        for (int i = 0; i < iterations; i++) {
            String fName;
            do {
                System.out.print("\nEnter first name: ");
                fName = scanner.nextLine();
            } while (fName.trim().isEmpty());

            // Use surname instead of last name, more ye-old
            String sName;
            do {
                System.out.print("Enter surname: ");
                sName = scanner.nextLine();
            } while (sName.trim().isEmpty());

            System.out.print("Enter age (must be between 12-100 and defaults to 20): ");
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

            Blacksmith blacksmith = new Blacksmith(fName, sName, age);
            this.villagers.add(blacksmith);

            System.out.print("\nEnter the forge to station the smith at: ");
            String forgeName = scanner.nextLine();

            // Use the Kingdom's name and "Forge" if user fails to enter anything
            if (forgeName.isEmpty()) {
                forgeName = "Forge " + this.name;
            }

            // Put a blacksmith with a forge, if the name already exists you don't need to create a new forge
            Forge forge = findOrCreateForge(forgeName);
            forge.addSmith(blacksmith);

            System.out.print("\nEnter which blacksmith school the smith belongs to: ");
            String blacksmithSchoolName = scanner.nextLine();

            // Use the Kingdom's name and "Blacksmith School" if user fails to enter anything
            if (blacksmithSchoolName.isEmpty()) {
                blacksmithSchoolName = "Blacksmith School " + this.name;
            }

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

        // Defaults differ for barns, silos and stables
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
        int windows = readIntInput("Enter number of windows forge has (default is 4): ", 4);
        int doors = readIntInput("Enter number of doors forge has (default is 1): ", 1);

        Forge newForge = new Forge(forgeName, buildingYearBuilt, windows, doors);
        forges.add(newForge);
        return newForge;
    }

    // Build blacksmith school
    private BlacksmithSchool findOrCreateBlacksmithSchool(String blacksmithSchoolName) {
        for (BlacksmithSchool blacksmithSchool : blacksmithSchools) {
            if (blacksmithSchool.getBuildingName().equals(blacksmithSchoolName)) {
                return blacksmithSchool;
            }
        }

        int buildingYearBuilt = readIntInput("Enter year school built (enter nothing to use current year): ", Calendar.getInstance().get(Calendar.YEAR));
        int windows = readIntInput("Enter number of windows school has (default is 8): ", 8);
        int doors = readIntInput("Enter number of doors school has (default is 2): ", 2);

        BlacksmithSchool newBlacksmithSchool = new BlacksmithSchool(blacksmithSchoolName, buildingYearBuilt, windows, doors);
        blacksmithSchools.add(newBlacksmithSchool);
        return newBlacksmithSchool;
    }


    // Read inputs for forge, blacksmith school & fort, override interface
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

    // Output details of forts
    public void printForts() {
        for (Fort fort : forts) {
            System.out.println("\nFort: " + fort.getBuildingName() + ", ID: " + fort.getFortID() + ", year built: " + fort.getBuildingYearBuilt() + ", windows: " + fort.getWindows() + ", doors: " + fort.getDoors());
            System.out.println("Knights");
            System.out.println("______");
            for (Knight knight : fort.getKnights()) {
                knight.print();
            }
        }
    }

    public void printForges() {
        for (Forge forge : forges) {
            System.out.println("\nForge: " + forge.getBuildingName() + ", year built: " + forge.getBuildingYearBuilt() + ", windows: " + forge.getWindows() + ", doors: " + forge.getDoors());

            if (forge.isHasLumberMill()) {
                System.out.println("This forge has a lumber mill!");
            }

            System.out.println("Blacksmiths: ");
            System.out.println("______");
            for (Blacksmith blacksmith : forge.getBlacksmiths()) {
                blacksmith.print();
            }
        }
    }

    public void printBlacksmithSchools() {
        for (BlacksmithSchool blacksmithSchool : blacksmithSchools) {
            System.out.println("\nBlacksmith School: " + blacksmithSchool.getBuildingName() + ", year built: " + blacksmithSchool.getBuildingYearBuilt() + ", windows: " + blacksmithSchool.getWindows() + ", doors: " + blacksmithSchool.getDoors());
            System.out.println("School Max Teaching Level - " + blacksmithSchool.getSchoolLevel());

            System.out.println("Blacksmiths: ");
            System.out.println("______");
            for (Blacksmith blacksmith : blacksmithSchool.getBlacksmiths()) {
                blacksmith.print();
            }
        }
    }

}
