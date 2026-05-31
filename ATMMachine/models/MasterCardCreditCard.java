package ATMMachine.models;

import ATMMachine.enums.CardType;

public class MasterCardCreditCard extends Card implements MasterCard, Credit {
    public MasterCardCreditCard(long cardNumber, int pin, String cardHolderName, String bankName) {
        super(cardNumber, pin, cardHolderName, CardType.CREDIT, bankName);
    }

    @Override
    public void connectToMasterCard() {
        System.out.println("Connecting to MasterCard");
    }

    @Override
    public void makePinPayment() {
        this.connectToMasterCard();
        System.out.println("Making pin payment with MasterCard credit card");
    }
}
