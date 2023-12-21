package ru.gb;

public class IllegalArgumentException extends Exception {
    private int balance;
    
    public IllegalArgumentException(String msg, int balance) {
        super(msg);
        this.balance = balance;
        
    }

    public int getBalance() {
        return balance;
    }
}


