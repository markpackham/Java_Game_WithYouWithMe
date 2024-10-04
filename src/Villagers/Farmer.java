package Villagers;

public class Farmer extends Villager implements VillagerPrinter {

    private FarmTools farmTools;

    public Farmer(String firstName, String lastName, int age) {
        super(firstName, lastName, age);
    }

    private void selectTool() {
    }

    public FarmTools getSmithTools() {
        return farmTools;
    }

    @Override
    public void print() {
        System.out.println("Name: " + this.FirstName + " " + this.LastName);
        System.out.println("Age: " + this.Age);
        System.out.println("Skill Level: " + getSmithTools());
    }
}
