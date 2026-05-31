package ATMMachine.models;

import ATMMachine.enums.CardType;

public class VisaDebitCard extends Card implements Visa, Debit {
    public VisaDebitCard(long cardNumber, int pin, String cardHolderName, String bankName) {
        super(cardNumber, pin, cardHolderName, CardType.DEBIT, bankName);
    }

    @Override
    public void connectToVisa() {
        System.out.println("Connecting to Visa");
    }

    @Override
    public void makePinPayment() {
        this.connectToVisa();
        System.out.println("Making pin payment with Visa debit card");
    }
}
