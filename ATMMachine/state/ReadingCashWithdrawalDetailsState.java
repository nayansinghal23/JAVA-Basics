package ATMMachine.state;

import ATMMachine.enums.ATMState;
import ATMMachine.factories.CardManagerFactory;
import ATMMachine.models.ATM;
import ATMMachine.models.Card;
import ATMMachine.services.CardManagerService;

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
    public int dispenseCash(Card card, int amount, int transactionId) {
        throw new IllegalStateException("Cannot dispense cash in ReadingCashWithdrawalDetailsState");
    }

    @Override
    public void ejectCard() {
        throw new IllegalStateException("Cannot eject card in ReadingCashWithdrawalDetailsState");
    }

    @Override
    public boolean readCashWithdrawDetails(Card card, int transactionId, int amount) {
        CardManagerService manager = CardManagerFactory.getCardManagerService(card.getCardType());
        boolean isValid = manager.validateWithdrawal(transactionId, amount);
        if(isValid) {
            this.atm.changeATMState(new DispensingCashState(this.atm));
        }
        else {
            this.atm.changeATMState(new EjectingCardState(this.atm));
        }
        return isValid;
    }

    @Override
    public ATMState getState() {
        return ATMState.READING_CASH_WITHDRAWAL_DETAILS;
    }

    @Override
    public boolean cancelTransaction(int transactionId) {
        try {
            this.atm.changeATMState(new ReadyForTransaction(atm));
            return true;
        } catch (Exception e) {
            System.out.println("Failed to cancel transaction " + e);
            return false;
        }
    }
}
