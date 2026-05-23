/**
 * UPI is only supported by Rupay. Diners card doesn't support refunds. And, intlPayment() is not supported by Rupay card. For intlPayment(), only MasterCard expects a pin rest others doesn't expects a pin.
 * 
 * SOLUTION : What if instead of making it abstract, we only add upiPayment() to RupayCreditCard class.
 * 
 * This above approach has 2 significant issues:
 * 1. What if any other credit card wants to support UPI in future?
 * 2. Code duplication for intlPayment() method that expects a pin.
 * 
 * All of this violets ISP which states that a child shouldn't be forced to implement methods that it doesn't need, this is somewhat similar to LSP.
 */

package SOLID.Example4.ProblematicCode;

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

    public abstract void swipeAndPay();
    public abstract void doRefund();
    public abstract void onlinePayment();
    public abstract void tapAndPay();
    public abstract void upiPayment();
    public abstract void intlPayment();
}
