package ATMMachine.state;

import ATMMachine.enums.ATMState;
import ATMMachine.models.ATM;
import ATMMachine.models.Card;

public class ReadingCashWithdrawalDetailsState implements State {
    private final ATM atm;

    public ReadingCashWithdrawalDetailsState(ATM atm) {
        this.atm = atm;
    }

    @Override
    public int initTransaction() {
        throw new IllegalStateException("Cannot initialize transaction in ReadingCashWithdrawalDetailsState");
    }

    @Override
    public boolean readCardDetailsAndPin(Card card) {
        throw new IllegalStateException("Cannot read card details and pin in ReadingCashWithdrawalDetailsState");
    }

    @Override
    public int dispenseCash(int transactionId) {
        throw new IllegalStateException("Cannot dispense cash in ReadingCashWithdrawalDetailsState");
    }

    @Override
    public void ejectCard() {
        throw new IllegalStateException("Cannot eject card in ReadingCashWithdrawalDetailsState");
    }

    @Override
    public boolean readCashWithdrawDetails(int transactionId, int amount) {
        throw new IllegalStateException("Cannot read cash withdrawal details in ReadingCashWithdrawalDetailsState");
    }

    @Override
    public ATMState getState() {
        return ATMState.READING_CASH_WITHDRAWAL_DETAILS;
    }
}
