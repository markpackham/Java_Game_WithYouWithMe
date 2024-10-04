package Villagers;

public class Farmer extends Villager {

    private FarmTools farmTools;

    public Farmer(String firstName, String lastName, int age) {
        super(firstName, lastName, age);
    }

    private void selectTool() {
    }

    public FarmTools getSmithTools() {
        return farmTools;
    }
}
