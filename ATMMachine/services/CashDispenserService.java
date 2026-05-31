package ATMMachine.services;

import ATMMachine.models.ATM;

public interface CashDispenserService {
    void dispenseCash(ATM atm, int amount);
}
