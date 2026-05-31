package ATMMachine.state;

import ATMMachine.enums.ATMState;
import ATMMachine.models.Card;

public interface State {
    int initTransaction();
    boolean readCardDetailsAndPin(Card card);
    int dispenseCash(Card card, int amount, int transactionId);
    void ejectCard();
    boolean readCashWithdrawDetails(Card card, int transactionId, int amount);
    ATMState getState();
    boolean cancelTransaction(int transactionId);
}
