package Villagers;

import java.util.Random;

public class Blacksmith extends Villager implements VillagerPrinter {

    private SmithTools smithTools;
    // Skill levels never change so can be stored in an array
    private final String[] skillLevels = {"apprentice", "journeyman", "master"};
    private String skillLevel;

    public Blacksmith(String firstName, String lastName, int age) {
        super(firstName, lastName, age);

        Random rand = new Random();
        // Select skill level at random
        skillLevel = skillLevels[rand.nextInt(0, skillLevels.length)];

        System.out.println("\nBlacksmith created\n");
        print();
    }

    public String getSkillLevel() {
        return skillLevel;
    }

    @Override
    public void print() {
        System.out.println("Name: " + this.FirstName + " " + this.LastName + " Age: " + this.Age);
        System.out.println("Skill Level: " + getSkillLevel());
    }
}
