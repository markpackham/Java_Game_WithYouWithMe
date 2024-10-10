import Territory.Farmland;
import Territory.Kingdom;
import Villagers.Villager;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


// Entry point for the game
public class Main {

    public static void main(String[] args) {

        // Create an empty list of villagers to populate the kingdom & farmland territories
        List<Villager> villagers = new ArrayList<>();

        System.out.println("Welcome to the Kingdom and Farmland creator!");

        // Init Scanner for user input
        Scanner scanner = new Scanner(System.in);

        // Kingdom creation
        System.out.print("Do you want to create a kingdom, please enter 'y' for 'yes' or anything else for 'no'? ");
        String answer = scanner.nextLine();

        // Ignore case if user has capslock on by mistake
        if (answer.equalsIgnoreCase("y") || answer.equalsIgnoreCase("yes")) {
            Kingdom kingdom = new Kingdom("", villagers);
            System.out.println("\nReport on The Kingdom of " + kingdom.getName() + " complete!\n\n");
        }

        // Farmland creation
        System.out.print("Do you want to create some farmland, please enter 'y' for 'yes' or anything else for 'no'? ");
        String answerFarmland = scanner.nextLine();

        if (answerFarmland.equalsIgnoreCase("y") || answerFarmland.equalsIgnoreCase("yes")) {
            Farmland farmland = new Farmland("", villagers);
            System.out.println("\nReport on the farmland of " + farmland.getName() + " complete!\n\n");
        }

        System.out.println("\nReport Finished!");

        System.out.print("Please type 'exit','quit' or 'q' to exit this program: ");
        String exitProgram = scanner.nextLine().toLowerCase();

        if (exitProgram.equalsIgnoreCase("exit") || exitProgram.equalsIgnoreCase("q") || exitProgram.equalsIgnoreCase("quit")) {
            // Exit the program
            System.exit(0);
        }

    }
}
