import Territory.Kingdom;
import Villagers.Villager;

import java.util.ArrayList;
import java.util.List;

// Entry point for the game
public class Main {
    public static void main(String[] args){

        // Create an empty list of villagers
        List<Villager> villagers = new ArrayList<>();

        System.out.println("Welcome to the Game!");

        // Test kingdom build
        Kingdom kingdom = new Kingdom("", villagers);

    }
}
