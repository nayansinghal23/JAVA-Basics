package SOLID.Example4.BetterCode;

import SOLID.Example4.BetterCode.InternationalPayment.InternationalPaymentCompatibleCreditCard;
import SOLID.Example4.BetterCode.InternationalPayment.InternationalPaymentStrategy;

public class MasterCardCreditCard extends CreditCard implements RefundCompatibleCreditCard, InternationalPaymentCompatibleCreditCard {
    private InternationalPaymentStrategy intlPaymentStrategy;

    public MasterCardCreditCard(String cardNumber, String cardHolder, String expiryDate, int cvv, InternationalPaymentStrategy intlPaymentStrategy) {
        super(cardNumber, cardHolder, expiryDate, cvv);
        this.intlPaymentStrategy = intlPaymentStrategy;
    }

    @Override
    public void swipeAndPay() {
        System.out.println("Swipe and pay with MasterCard card");
    }
    
    @Override
    public void tapAndPay() {
        System.out.println("Tap and pay with MasterCard card");
    }

    @Override
    public void doRefund() {
        System.out.println("Do refund with MasterCard card");
    }

    @Override
    public void onlinePayment() {
        System.out.println("Online payment with MasterCard card");
    }

    @Override
    public void intlPayment() {
        this.intlPaymentStrategy.intlPayment();
    }
}
