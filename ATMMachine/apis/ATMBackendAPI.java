package ATMMachine.apis;

import java.util.UUID;

import ATMMachine.DTO.CreateTransactionDTO;

public class ATMBackendAPI implements BackendAPI {
    @Override
    public int generateTransactionId(CreateTransactionDTO createTransactionDTO) {
        String atmId = createTransactionDTO.getAtmId();

        if(atmId == null || atmId.isEmpty()) {
            throw new IllegalArgumentException("ATM ID cannot be null or empty");
        }

        // API Call to generate transaction id.
        String transactionId = atmId + "-" + UUID.randomUUID().toString();
        return transactionId.hashCode();
    }
}
