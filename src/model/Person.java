package model;

public class Person implements Displayable{

    protected String name;

    public Person() {}

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Polymorphism base method
    public void showDetails() {
        System.out.println("Name: " + name);
    }
}