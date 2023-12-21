package ru.gb;

public class Account {
    private boolean isBeginBalance = true;
    private int balance = 0;

    public String getBalance() {
        return String.format("Ваш баланс составляет: %d", balance);
    }

    public void setBalance(int balance) throws ChangeInitialAmount, IllegalArgumentException {
        
        if (balance < 0)
            throw new IllegalArgumentException("Попытка создать счет с отрицательным начальным балансом %d", balance);
        else  if (isBeginBalance) {
            this.balance = balance;
            isBeginBalance = false;
        } 
        else
            throw new ChangeInitialAmount("Попытка изменить начальную сумму");
    }

    public void setDeposit(int deposit) throws IllegalArgumentException {
        if (deposit > 0)
            this.balance += deposit;
        else
            throw new IllegalArgumentException("Попытка внести депозит с некорректной суммой %d ", deposit);
    }

    public void setWithdrawals(int withdrawals) throws InsufficientFundsException {
        if (withdrawals <= this.balance)
            this.balance = this.balance - withdrawals;
        else 
            throw new InsufficientFundsException("Попытка снять средства %d, сумма которых превышает текущий баланс %d",
                    this.balance, withdrawals);
    }
}
