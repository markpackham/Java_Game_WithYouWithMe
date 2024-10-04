package Villagers;

// Ultra generic class to base other human classes off
// the subclasses will be used to give villagers professions
public abstract class Villager {

    protected String FirstName;
    protected String LastName;
    protected int Age;

    public Villager(String firstName, String lastName, int age) {
        FirstName = firstName;
        LastName = lastName;
        Age = age;
    }

}
