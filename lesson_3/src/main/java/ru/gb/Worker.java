package ru.gb;

public class Worker extends Human {
    private float salary;
    public Worker(String firsName, String lastName, int age, float salary) {
        super(firsName, lastName, age);
        this.salary = salary;

    }
    @Override
    public float calcSalary() {
        return getSalary();
    }

    public float getSalary() {
        return salary;
    }

}
