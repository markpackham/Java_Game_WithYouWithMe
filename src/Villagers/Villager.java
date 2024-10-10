package Villagers;

// Ultra generic class to base other human classes off
public abstract class Villager {

    // Attributes protected since we need child classes of knights, blacksmiths and farmers to access them
    protected String FirstName;
    protected String Surname;
    protected int Age;

    public Villager(String firstName, String surname, int age) {
        FirstName = firstName;
        Surname = surname;
        Age = age;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }
}
