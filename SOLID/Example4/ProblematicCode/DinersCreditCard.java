package SOLID.Example4.ProblematicCode;

public class DinersCreditCard extends CreditCard {
    public DinersCreditCard(String cardNumber, String cardHolder, String expiryDate, int cvv) {
        super(cardNumber, cardHolder, expiryDate, cvv);
    }

    @Override
    public void swipeAndPay() {
        System.out.println("Swipe and pay with Diners card");
    }
    
    @Override
    public void doRefund() {
        System.out.println("Do refund with Diners card");
    }

    @Override
    public void onlinePayment() {
        System.out.println("Online payment with Diners card");
    }
    
    @Override
    public void tapAndPay() {
        System.out.println("Tap and pay with Diners card");
    }

    @Override
    public void upiPayment() {
        System.out.println("UPI payment with Diners card");
    }

    @Override
    public void intlPayment() {
        System.out.println("International payment with Diners card");
    }
}
