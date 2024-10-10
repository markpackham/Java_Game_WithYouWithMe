package Villagers;

// Ultra generic class to base other human classes off
public abstract class Villager {

    // Attributes protected since we need child classes of knights, blacksmiths and farmers to access them
    protected String FirstName;
    protected String LastName;
    protected int Age;

    public Villager(String firstName, String lastName, int age) {
        FirstName = firstName;
        LastName = lastName;
        Age = age;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }
}
