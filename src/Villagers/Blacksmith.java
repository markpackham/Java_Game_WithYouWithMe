package Villagers;

import java.util.Random;

public class Blacksmith extends Villager implements VillagerPrinter {

    // SKILL_LEVELS never change so can be stored in an array & be a constant
    private final String[] SKILL_LEVELS = {"apprentice", "journeyman", "master"};
    private final String skillLevel;

    public Blacksmith(String firstName, String lastName, int age) {
        super(firstName, lastName, age);

        Random rand = new Random();
        // Select skill level at random
        skillLevel = SKILL_LEVELS[rand.nextInt(0, SKILL_LEVELS.length)];

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
