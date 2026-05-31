package ATMMachine.services;

import ATMMachine.DTO.ATMAmountDTO;
import ATMMachine.apis.ATMBackendAPI;
import ATMMachine.apis.BackendAPI;
import ATMMachine.models.ATM;

public class CashDispenseServiceImpl implements CashDispenserService {
    private final BackendAPI backendAPI;

    public CashDispenseServiceImpl() {
        this.backendAPI = new ATMBackendAPI();
    }

    @Override
    public void dispenseCash(ATM atm, int amount) {
        int atmAmount = this.backendAPI.getATMAmount(new ATMAmountDTO(atm.getAtmId()));

        if(atmAmount < amount) {
            throw new RuntimeException("ATM does not have enough cash");
        }

        System.out.println("Dispensing cash: " + amount);
    }
    
}
