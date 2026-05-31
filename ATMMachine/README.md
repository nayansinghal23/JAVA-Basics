# ATM Machine

### Requirements ->

1. Single transaction support - No concurrent transactions
2. Provide start button to initiate a trasaction.
3. Machine should prompt user to insert card. System should validate card details post insertion.
4. If card is invalid, system should reject the transaction.
5. After validating card, system should ask user to enter withdrawal amount.
6. Validations to check if withdrawal amount is under the user's balance and machine's threshold.
7. Dispense money and eject the card.

### Solution-1 ->

We are going to have a single class ATM that contains all the functions like `startTransaction()`, `cancelTransaction()`, `readCard()`, `withdrawAmount()`, `dispenseCash()`, `validateCardDetails()`, etc.

Problems ->

1. This solution is just for 1 ATM machine but in a bank there are multiple ATM machines. Inclusion of `atmId` will be great.
2. A user can start a transaction back to back `atm.startTransaction()`. We need to restrict it. There must be some mechanism to track the state of the machine.

### Solution-2 ->

```java
public class ATM {
    private enum ATMState {
        IDLE, TRANSACTION_IN_PROGRESS, CARD_INSERTED, AMOUNT_ENTERED, DISPENSING_CASH
    }

    private final String atmId;
    private ATMState state;

    public ATM(String atmId) {
        this.atmId = atmId;
        state = ATMState.IDLE;
    }

    public int startTransaction() {
        if(state != ATMState.IDLE) {
            throw new IllegalStateException("some message");
        }
        state = ATMState.TRANSACTION_IN_PROGRESS
        int transactionId = generateTransactionId(); // API Call
        return transactionId;
    }

    public void cancelTransaction() {
        if(state == ATMState.IDLE) {
            throw new IllegalStateException("some message");
        }
        if(state == ATMState.DISPENSING_CASH) {
            throw new IllegalStateException("some message");
        }
        state = ATMState.IDLE;
    }

    public boolean readCard(String cardType, long cardNumber, int pin) {
        if(state != ATMState.TRANSACTION_IN_PROGRESS) {
            throw new IllegalStateException("some message");
        }
        boolean isValid = validateCardDetails(cardType, cardNumber, pin) // API call
        if(isValid) state = ATMState.CARD_INSERTED;
        return isValid;
    }

    ....
    ....
    ....
}
```

This is definitely a better solution than the previous one as we have maintained atmId as a unique identified for all atms of a bank. Also, by introducting states, we are preventing multiple transactions to occur at same time.

Problems ->

1. Violets SRP since ATM class handles all the responsibilies.
2. Violets OCP since you can have multiple checks for each state and each check can have different logs.

### Solution-3 ->

Instead of enums, lets create classes for each state and we can have a composition of each state classes in ATM class.

```java
    public class ATM {
        private final CashDispensingState cashDispensingState;
        private final CardReadingState cardReadingState;

        public ATM() {
            this.cashDispensingState = new CashDispensingState();
            this.cardReadingState = new CardReadingState();
        }
    }

    public class CashDispensingState {
        public void cancelTransaction() {...}

        public boolean readCard() {...}
    }

    public class CardReadingState {
        public void cancelTransaction() {...}

        public boolean readCard() {...}
    }
```



Problem -> We still lack addition of new states because ATM class in dependent on concrete implementation of state classes, thus violeting DIP.

### Solution-4 ->

Instead of mutliple state compositions, how about we have a state interface and then multiple classes can implement this interface and out ATM class will be only depending on one state object which will be getting instance of corresponding state based on what is going on in the transaction.