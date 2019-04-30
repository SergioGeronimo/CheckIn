package models;
//Person by Sergio Geronimo on 29/04/2019


public class Person {
    private String id, name, lastName;
    private int pin;

    public Person(String id, String name, String lastName, int pin) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.pin = pin;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    @Override
    public String toString() {
        return this.name + " " + this.lastName;
    }
}
