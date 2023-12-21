package ru.gb;

/**
 * Hello world!
 *
 */
public class Program 
{
    public static void main( String[] args )
    {
        Account account = new Account();
        try {
            account.setBalance(1000);
//            account.setBalance(100);
            account.setDeposit(100);
            account.setWithdrawals(1000);
            
            System.out.println(account.getBalance());
        } catch (ChangeInitialAmount e) {
            System.out.println(e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.printf(e.getMessage(), e.getBalance());
        } catch (InsufficientFundsException e) {
            System.out.printf(e.getMessage(), e.getWithdrawals(), e.getBalance());
        }

    }
}

