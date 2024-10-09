package Villagers;

import Villagers.Equipment.FarmTools;

import java.util.Scanner;

public class Farmer extends Villager implements VillagerPrinter {

    private FarmTools farmTool;

    public Farmer(String firstName, String lastName, int age) {
        super(firstName, lastName, age);
        selectTools();
        System.out.println("\nFarmer created\n");
        print();
    }

    private void selectTools() {
        int i = 1;
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nSelect your tool, this is case sensative!: ");
        // Iterate through Enum of tools printing each
        for (FarmTools ft : FarmTools.values()) {
            System.out.println(ft);
            i++;
        }

        System.out.print("Enter the tool your farmer uses: ");
        String farmT = scanner.nextLine();
        // Compares the input to all the possible Enum values
        for (FarmTools ft : FarmTools.values()) {
            if (farmT.equalsIgnoreCase(ft.toString())) {
                this.farmTool = ft;
                break;
            }
        }

        // Checks to ensure a farm tool was chosen or calls for a selection again
        if (this.farmTool == null) {
            System.out.println("Incorrect choice. Please select a tool from the list e.g. Fork\n\n");
            selectTools();
        }
    }

    public FarmTools getFarmTool() {
        return farmTool;
    }

    @Override
    public void print() {
        System.out.println("Name: " + this.FirstName + " " + this.LastName + " Age: " + this.Age);
        System.out.println("Tool: " + getFarmTool());
    }
}
