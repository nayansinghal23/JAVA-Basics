package FacadeDesignPattern.BasicExample;

public class Funds {
    public boolean hasSufficientFunds(String accountNumber, int amount) {
        System.out.println("Checking if account number: " + accountNumber + " has sufficient funds for amount: " + amount);
        return true;
    }

    public void deductFunds(String accountNumber, int amount) {
        System.out.println("Deducting funds from account number: " + accountNumber + " for amount: " + amount);
    }
}
