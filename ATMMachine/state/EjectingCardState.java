package ATMMachine.state;

import ATMMachine.enums.ATMState;
import ATMMachine.models.ATM;
import ATMMachine.models.Card;

public class EjectingCardState implements State {
    private final ATM atm;

    public EjectingCardState(ATM atm) {
        this.atm = atm;
    }

    @Override
    public int initTransaction() {
        throw new IllegalStateException("Cannot initialize transaction in EjectingCardState");
    }

    @Override
    public boolean readCardDetailsAndPin(Card card) {
        throw new IllegalStateException("Cannot read card details and pin in EjectingCardState");
    }

    @Override
    public int dispenseCash(Card card, int amount, int transactionId) {
        throw new IllegalStateException("Cannot dispense cash in EjectingCardState");
    }

    @Override
    public void ejectCard() {
        System.out.println("Please take out your card");
        this.atm.changeATMState(new ReadyForTransaction(this.atm));
    }

    @Override
    public boolean readCashWithdrawDetails(Card card, int transactionId, int amount) {
        throw new IllegalStateException("Cannot read cash withdrawal details in EjectingCardState");
    }

    @Override
    public ATMState getState() {
        return ATMState.EJECTING_CARD;
    }

    @Override
    public boolean cancelTransaction(int transactionId) {
        throw new IllegalStateException("Cannot cancel transaction in EjectingCardState");
    }
}
