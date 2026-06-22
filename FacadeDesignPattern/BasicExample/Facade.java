package FacadeDesignPattern.BasicExample;

public class Facade {
    private final Account account;
    private final SecurityPin securityPin;
    private final Funds funds;
    private final Notifications notifications;

    public Facade() {
        this.account = new Account();
        this.securityPin = new SecurityPin();
        this.funds = new Funds();
        this.notifications = new Notifications();
    }

    public void withdraw(String accountNumber, int amount, String securityPin) {
        System.out.println("Withdrawing funds from account number: " + accountNumber + " for amount: " + amount);
        if(this.account.verifyAccount(accountNumber) && this.securityPin.verifySecurityPin(securityPin) && this.funds.hasSufficientFunds(accountNumber, amount)) {
            this.funds.deductFunds(accountNumber, amount);
            this.notifications.sendNotification("Funds withdrawn successfully");
        }
        else {
            this.notifications.sendNotification("Funds withdrawal failed");
        }
    }
}
