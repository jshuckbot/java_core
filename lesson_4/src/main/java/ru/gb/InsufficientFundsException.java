package ru.gb;

public class InsufficientFundsException extends Exception {
    private int balance;
    private int withdrawals;
    
    public InsufficientFundsException(String msg, int balance, int withdrawals) {
        super(msg);
        this.balance = balance;
        this.withdrawals = withdrawals;
    }

    public int getBalance() {
        return balance;
    }

    public int getWithdrawals() {
        return withdrawals;
    }
}
