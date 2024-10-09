import Territory.Farmland;
import Territory.Kingdom;
import Villagers.Villager;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


// Entry point for the game
public class Main {

    public static void main(String[] args) {

        // Create an empty list of villagers
        List<Villager> villagers = new ArrayList<>();

        System.out.println("Welcome to the Kingdom and Farmland creator!");

        // Init Scanner
        Scanner scanner = new Scanner(System.in);

        // Kingdom creation
        System.out.print("Do you want to create a kingdom, please enter 'y' for 'yes' or anything else for 'no'? ");
        // If user has capslock on change word to lower case
        String answer = scanner.nextLine().toLowerCase();

        if(answer.equals("y") || answer.equals("yes")){
            Kingdom kingdom = new Kingdom("", villagers);
            System.out.println("Report on The Kingdom of "+kingdom.getName() + " complete!\n");
        }

        // Farmland creation
        System.out.print("Do you want to create some farmland, please enter 'y' for 'yes' or anything else for 'no'? ");
        String answerFarmland = scanner.nextLine().toLowerCase();

        if(answerFarmland.equals("y") || answerFarmland.equals("yes")){
            Farmland farmland = new Farmland("", villagers);
            System.out.println("Report on the farmland of "+farmland.getName() + " complete!\n");
        }

        System.out.println("\nReport Finished!");

        System.out.print("Please type 'exit','quit' or 'q' to exit this program.");
        String exitProgram = scanner.nextLine().toLowerCase();

        if(exitProgram.equalsIgnoreCase("exit") || exitProgram.equalsIgnoreCase("q") || exitProgram.equalsIgnoreCase("quit")){
            // Exit the program
            System.exit(0);
        }

    }
}
