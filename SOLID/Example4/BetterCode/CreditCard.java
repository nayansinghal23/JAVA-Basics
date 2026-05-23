package SOLID.Example4.BetterCode;

public abstract class CreditCard {
    private String cardNumber;
    private String cardHolder;
    private String expiryDate;
    private int cvv;

    public CreditCard(String cardNumber, String cardHolder, String expiryDate, int cvv) {
        this.cardNumber = cardNumber;
        this.cardHolder = cardHolder;
        this.expiryDate = expiryDate;
        this.cvv = cvv;
    }

    public String getCardNumber() {
        return this.cardNumber;
    }

    public String getCardHolder() {
        return this.cardHolder;
    }
    
    public String getExpiryDate() {
        return this.expiryDate;
    }

    public int getCvv() {
        return this.cvv;
    }

    // Keeping those behaviors that are common to all credit cards in abstract class.
    public abstract void swipeAndPay();
    public abstract void tapAndPay();
    public abstract void onlinePayment();
}