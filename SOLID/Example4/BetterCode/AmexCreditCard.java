package SOLID.Example4.BetterCode;

import SOLID.Example4.BetterCode.InternationalPayment.InternationalPaymentCompatibleCreditCard;
import SOLID.Example4.BetterCode.InternationalPayment.InternationalPaymentStrategy;

public class AmexCreditCard extends CreditCard implements RefundCompatibleCreditCard, InternationalPaymentCompatibleCreditCard {
    private InternationalPaymentStrategy intlPaymentStrategy;

    public AmexCreditCard(String cardNumber, String cardHolder, String expiryDate, int cvv, InternationalPaymentStrategy intlPaymentStrategy) {
        super(cardNumber, cardHolder, expiryDate, cvv);
        this.intlPaymentStrategy = intlPaymentStrategy;
    }

    @Override
    public void swipeAndPay() {
        System.out.println("Swipe and pay with Amex card");
    }

    @Override
    public void tapAndPay() {
        System.out.println("Tap and pay with Amex card");
    }

    @Override
    public void onlinePayment() {
        System.out.println("Online payment with Amex card");
    }

    @Override
    public void doRefund() {
        System.out.println("Do refund with Amex card");
    }

    @Override
    public void intlPayment() {
        this.intlPaymentStrategy.intlPayment();
    }
}
