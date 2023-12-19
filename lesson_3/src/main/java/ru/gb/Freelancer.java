package ru.gb;

public class Freelancer extends Human {
    private float rate;
    public Freelancer(String firsName, String lastName, int age, float rate) {
        super(firsName, lastName, age);
        this.rate = rate;
    }
    
    @Override
    public float calcSalary() {
        return 20.8f * 8 * getRate();
    }

    public float getRate() {
        return rate;
    }
}
