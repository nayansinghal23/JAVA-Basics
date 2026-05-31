package ATMMachine.apis;

import ATMMachine.DTO.CreateTransactionDTO;

public interface BackendAPI {
    int generateTransactionId(CreateTransactionDTO createTransactionDTO);
}
