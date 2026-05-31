package ATMMachine.state;

import ATMMachine.enums.ATMState;
import ATMMachine.models.Card;

public interface State {
    int initTransaction();
    boolean readCardDetailsAndPin(Card card);
    int dispenseCash(int transactionId);
    void ejectCard();
    boolean readCashWithdrawDetails(int transactionId, int amount);
    ATMState getState();
}
