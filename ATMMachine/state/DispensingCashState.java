package ATMMachine.state;

import ATMMachine.enums.ATMState;
import ATMMachine.factories.CardManagerFactory;
import ATMMachine.models.ATM;
import ATMMachine.models.Card;
import ATMMachine.services.CardManagerService;
import ATMMachine.services.CashDispenseServiceImpl;
import ATMMachine.services.CashDispenserService;

public class DispensingCashState implements State {
    private final ATM atm;
    private final CashDispenserService cashDispenserService;

    public DispensingCashState(ATM atm) {
        this.atm = atm;
        this.cashDispenserService = new CashDispenseServiceImpl();
    }

    @Override
    public int initTransaction() {
        throw new IllegalStateException("Cannot initialize transaction in DispensingCashState");
    }

    @Override
    public boolean readCardDetailsAndPin(Card card) {
        throw new IllegalStateException("Cannot read card details and pin in DispensingCashState");
    }
    
    @Override
    public int dispenseCash(Card card, int amount, int transactionId) {
        CardManagerService manager = CardManagerFactory.getCardManagerService(card.getCardType());
        boolean isTransactionSuccessful = manager.doTransaction(card, amount, transactionId);
        if(!isTransactionSuccessful) {
            this.atm.changeATMState(new ReadyForTransaction(this.atm));
            throw new RuntimeException("Transaction failed");
        }

        this.cashDispenserService.dispenseCash(this.atm, transactionId);
        this.atm.changeATMState(new EjectingCardState(this.atm));
        return amount;
    }

    @Override
    public void ejectCard() {
        throw new IllegalStateException("Cannot eject card in DispensingCashState");
    }
    
    @Override
    public boolean readCashWithdrawDetails(Card card, int transactionId, int amount) {
        throw new IllegalStateException("Cannot read cash withdrawal details in DispensingCashState");
    }

    @Override
    public ATMState getState() {
        return ATMState.DISPENSING_CASH;
    }
    
    @Override
    public boolean cancelTransaction(int transactionId) {
        throw new IllegalStateException("Cannot cancel transaction in DispensingCashState");
    }
}
