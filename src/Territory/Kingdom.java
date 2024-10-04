package Territory;

import Villagers.Knight;
import Villagers.Villager;

import java.util.List;
import java.util.Scanner;

// Villagers are held in a territory
public class Kingdom extends Territory{

    private final Scanner scanner;

    public Kingdom(String name, List<Villager> villagers) {
        super(name, villagers);
        this.scanner = new Scanner(System.in);
        initTerritory();
    }

    private void initTerritory() {
        System.out.print("\nName of territory: ");
        this.name = scanner.nextLine();
        System.out.print("How many people live in your territory?: ");
        int numberOfVillagers = Integer.parseInt(scanner.nextLine());
        populateTerritory(numberOfVillagers);

        System.out.print("\nAll the people who live there\n");
        printVillagers();
    }

    // User must fill out the 3 villager parameters, then calls the Knight constructor
    private void populateTerritory(int iterations) {
        for (int i = 0; i < iterations; i++) {
            System.out.print("\nEnter Knight first name: ");
            String fName = scanner.nextLine();
            System.out.print("Enter Knight last name: ");
            String sName = scanner.nextLine();
            System.out.print("Enter Knight age: ");
            int age = Integer.parseInt(scanner.nextLine());
            this.villagers.add(new Knight(fName, sName, age));
        }
    }

    public void printVillagers(){
        for(Villager v: this.villagers){
            if(v.getClass()==Knight.class){
                ((Knight) v).print();
            }
        }
    }
}
