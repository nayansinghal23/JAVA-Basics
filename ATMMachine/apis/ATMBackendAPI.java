package ATMMachine.apis;

import java.util.UUID;

public class ATMBackendAPI implements BackendAPI {
    @Override
    public int generateTransactionId(String atmId) {
        if(atmId == null || atmId.isEmpty()) {
            throw new IllegalArgumentException("ATM ID cannot be null or empty");
        }

        // API Call to generate transaction id.
        String transactionId = atmId + "-" + UUID.randomUUID().toString();
        return transactionId.hashCode();
    }
}
