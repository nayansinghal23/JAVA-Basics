package ATMMachine.apis;

import ATMMachine.DTO.CreateTransactionDTO;
import ATMMachine.DTO.UpdateATMStateDTO;

public interface BackendAPI {
    int generateTransactionId(CreateTransactionDTO createTransactionDTO);
    boolean updateATMState(UpdateATMStateDTO updateATMStateDTO);
}
