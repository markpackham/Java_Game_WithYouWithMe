package Villagers;

public class Blacksmith extends Villager {

    private SmithTools smithTools;

    public Blacksmith(String firstName, String lastName, int age) {
        super(firstName, lastName, age);
    }

    private void selectTool() {
    }

    public SmithTools getSmithTools() {
        return smithTools;
    }
}
