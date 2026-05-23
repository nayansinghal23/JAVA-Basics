package SOLID.Example4.ProblematicCode;

public class RupayCreditCard extends CreditCard {
    public RupayCreditCard(String cardNumber, String cardHolder, String expiryDate, int cvv) {
        super(cardNumber, cardHolder, expiryDate, cvv);
    }

    @Override
    public void swipeAndPay() {
        System.out.println("Swipe and pay with Rupay card");
    }
    
    @Override
    public void doRefund() {
        System.out.println("Do refund with Rupay card");
    }

    @Override
    public void onlinePayment() {
        System.out.println("Online payment with Rupay card");
    }
    
    @Override
    public void tapAndPay() {
        System.out.println("Tap and pay with Rupay card");
    }

    @Override
    public void upiPayment() {
        System.out.println("UPI payment with Rupay card");
    }

    @Override
    public void intlPayment() {
        System.out.println("International payment with Rupay card");
    }
}
