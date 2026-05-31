package ATMMachine.state;

import ATMMachine.DTO.CreateTransactionDTO;
import ATMMachine.apis.BackendAPI;
import ATMMachine.enums.ATMState;
import ATMMachine.models.ATM;
import ATMMachine.models.Card;

public class ReadyForTransaction implements State {
    private final ATM atm;
    private final BackendAPI backendAPI;

    public ReadyForTransaction(ATM atm, BackendAPI backendAPI) {
        this.atm = atm;
        this.backendAPI = backendAPI;
    }

    @Override
    public int initTransaction() {
        // Check for ATM state to be in READY_FOR_TRANSACTION.
        // Generate transaction id.
        CreateTransactionDTO createTransactionDTO = new CreateTransactionDTO(this.atm.getAtmId());
        int transactionId = this.backendAPI.generateTransactionId(createTransactionDTO);
        if(transactionId <= 0) {
            throw new IllegalStateException("Failed to generate transaction id");
        }

        // Set the state to READ_CARD_DETAILS_AND_PIN.
        this.atm.changeATMState(new CardReadingState());
        return transactionId;
    }

    @Override
    public boolean readCardDetailsAndPin(Card card) {
        throw new IllegalStateException("Cannot read card details and pin in ReadyForTransaction state");
    }

    @Override
    public int dispenseCash(int transactionId) {
        throw new IllegalStateException("Cannot dispense cash in ReadyForTransaction state");
    }

    @Override
    public void ejectCard() {
        throw new IllegalStateException("Cannot eject card in ReadyForTransaction state");
    }

    @Override
    public boolean readCashWithdrawDetails(int transactionId, int amount) {
        throw new IllegalStateException("Cannot read cash withdrawal details in ReadyForTransaction state");
    }

    @Override
    public ATMState getState() {
        return ATMState.READY_FOR_TRANSACTION;
    }
}
