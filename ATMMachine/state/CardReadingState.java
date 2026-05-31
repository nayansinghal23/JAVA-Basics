package ATMMachine.state;

import ATMMachine.enums.ATMState;
import ATMMachine.factories.CardManagerFactory;
import ATMMachine.models.ATM;
import ATMMachine.models.Card;
import ATMMachine.services.CardManagerService;

public class CardReadingState implements State {
    private final ATM atm;

    public CardReadingState(ATM atm) {
        this.atm = atm;
    }

    @Override
    public int initTransaction() {
        throw new IllegalStateException("Cannot initialize transaction in CardReadingState");
    }

    @Override
    public boolean readCardDetailsAndPin(Card card) {
        // Check for ATM state to be in READ_CARD_DETAILS_AND_PIN state.
        // Validate card details and pin.
        /*
        BAD DESIGN -> Violets OCP
        if(card.getCardType().equals(CardType.DEBIT)) {}
        else if(card.getCardType().equals(CardType.CREDIT)) {}
        */
       CardManagerService manager = CardManagerFactory.getCardManagerService(card.getCardType());
       boolean isValid = manager.validateCard(card, card.getPin() + "");
       if(isValid) {
        this.atm.changeATMState(new ReadingCashWithdrawalDetailsState(this.atm));
       }
       else {
        this.atm.changeATMState(new ReadyForTransaction(this.atm));
       }
        return isValid;
    }

    @Override
    public int dispenseCash(int transactionId) {
        throw new IllegalStateException("Cannot dispense cash in CardReadingState");
    }

    @Override
    public void ejectCard() {
        throw new IllegalStateException("Cannot eject card in CardReadingState");
    }

    @Override
    public boolean readCashWithdrawDetails(int transactionId, int amount) {
        throw new IllegalStateException("Cannot read cash withdrawal details in CardReadingState");
    }

    @Override
    public ATMState getState() {
        return ATMState.READ_CARD_DETAILS_AND_PIN;
    }
}
