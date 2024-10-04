package Villagers;

import java.util.Random;
import java.util.Scanner;

public class Knight extends Villager{

    // Weapons Enum used
    private Weapons weapon;
    private int strength;

    public Knight(String firstName, String lastName, int age) {
        super(firstName, lastName, age);
        generateStrength();
        selectWeapon();
        System.out.println("\nKnight created\n");
        print();
    }

    private void generateStrength(){
        Random rand = new Random();
        strength = rand.nextInt(1, 10);
    }

    private void selectWeapon(){
        int i = 1;
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nSelect your weapon:");
        // Iterate through Enum of weapons printing each
        for(Weapons w: Weapons.values()){
        System.out.println(i + ": " + w);
        i++;
        }

        System.out.println("Enter weapons name: ");
        String weap = scanner.nextLine();
        // Compares the input to all the possible Enum values
        for(Weapons w: Weapons.values()){
            if(weap.equalsIgnoreCase(w.toString())){
                this.weapon = w;
                break;
            }
        }

        // Checks to ensure a weapon was chosen.
        // Calls selectWeapon() again if no valid input
        if(this.weapon==null){
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
    public void print(){
        System.out.println("Name: " + getFirstName() + " " + getLastName());
        System.out.println("Age: " + getAge());
        System.out.println("Strength: " + getStrength());
        System.out.println("Weapon " + getWeapon());
    }
}
