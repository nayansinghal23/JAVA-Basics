package SOLID.Example4.ProblematicCode;

public class AmexCreditCard extends CreditCard {
    public AmexCreditCard(String cardNumber, String cardHolder, String expiryDate, int cvv) {
        super(cardNumber, cardHolder, expiryDate, cvv);
    }

    @Override
    public void swipeAndPay() {
        System.out.println("Swipe and pay with Amex card");
    }
    
    @Override
    public void doRefund() {
        System.out.println("Do refund with Amex card");
    }

    @Override
    public void onlinePayment() {
        System.out.println("Online payment with Amex card");
    }
    
    @Override
    public void tapAndPay() {
        System.out.println("Tap and pay with Amex card");
    }

    @Override
    public void upiPayment() {
        System.out.println("UPI payment with Amex card");
    }

    @Override
    public void intlPayment() {
        System.out.println("International payment with Amex card");
    }
}
