package ATMMachine.services;

import ATMMachine.models.Card;

public class CreditCardManagerService implements CardManagerService {
    @Override
    public boolean validateCard(Card card, String pin) {
        // API call to validate card.
        return false;
    }

    @Override
    public boolean validateWithdrawal(Card card, double amount) {
        // API call to validate withdrawal.
        return false;
    }

    @Override
    public boolean doTransaction(Card card, double amount, int transactionId) {
        // API call to do transaction.
        return false;
    }
}
