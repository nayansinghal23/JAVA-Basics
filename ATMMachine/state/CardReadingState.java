package ATMMachine.state;

import ATMMachine.enums.ATMState;
import ATMMachine.models.Card;

public class CardReadingState implements State {
    @Override
    public int initTransaction() {
        throw new IllegalStateException("Cannot initialize transaction in CardReadingState");
    }

    @Override
    public boolean readCardDetailsAndPin(Card card) {
        // Check for ATM state to be in READ_CARD_DETAILS_AND_PIN state.
        boolean isValid = true;
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
