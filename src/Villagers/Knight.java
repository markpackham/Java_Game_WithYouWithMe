package Villagers;

import Villagers.Equipment.Weapons;

import java.util.Random;
import java.util.Scanner;

public class Knight extends Villager implements VillagerPrinter {

    // Weapons Enum used
    // Only knights have strength and weapons
    private Weapons weapon;
    private int strength;

    public Knight(String firstName, String lastName, int age) {
        super(firstName, lastName, age);
        generateStrength();
        selectWeapon();
        System.out.println("\nKnight created\n");
        print();
    }

    private void generateStrength() {
        Random rand = new Random();
        strength = rand.nextInt(1, 10);
    }

    private void selectWeapon() {
        int i = 1;
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nSelect your weapon, this is case sensitive!: ");
        // Iterate through Enum of weapons printing each
        for (Weapons w : Weapons.values()) {
            System.out.println(w);
            i++;
        }

        System.out.print("Enter the weapon your knight uses: ");
        String weap = scanner.nextLine();
        // Compares the input to all the possible Enum values
        for (Weapons w : Weapons.values()) {
            if (weap.equalsIgnoreCase(w.toString())) {
                this.weapon = w;
                break;
            }
        }

        // Checks to ensure a weapon was chosen.
        // Calls selectWeapon() again if no valid input
        if (this.weapon == null) {
            System.out.println("Incorrect choice. Please select a weapon from the list e.g. Sword\n\n");
            selectWeapon();
        }
    }

    public Weapons getWeapon() {
        return weapon;
    }

    public int getStrength() {
        return strength;
    }

    // Print out knight info
    @Override
    public void print() {
        System.out.println("Name: " + this.FirstName + " " + this.LastName + " Age: " + this.Age);
        System.out.println("Strength: " + getStrength());
        System.out.println("Weapon " + getWeapon());
    }
}
