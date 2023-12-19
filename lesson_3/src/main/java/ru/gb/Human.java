package ru.gb;

import java.util.Comparator;

public abstract class Human implements Comparable<Human> {
    private String firstName;
    private String lastName;
    private int age;

    public Human(String firsName, String lastName, int age) {
        this.firstName =firsName;
        this.lastName = lastName;
        this.age = age;
    }

    public abstract float calcSalary();

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return getFirstName() + " " + getLastName()+ " salary: " + calcSalary();
    }
    
    @Override
    public int compareTo(Human otherHuman) {
        if (this.calcSalary() < otherHuman.calcSalary())
            return -1;
        else if (this.calcSalary() == otherHuman.calcSalary())
            return 0;
        else
            return 1;
    }
}


