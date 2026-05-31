package ATMMachine.models;


import ATMMachine.DTO.UpdateATMStateDTO;
import ATMMachine.apis.ATMBackendAPI;
import ATMMachine.apis.BackendAPI;
import ATMMachine.state.ReadyForTransaction;
import ATMMachine.state.State;

public class ATM {
    private final String atmId;
    private final BackendAPI backendAPI;
    private State state;

    public ATM(String atmId) {
        this.atmId = atmId;
        this.backendAPI = new ATMBackendAPI();
        this.state = new ReadyForTransaction(this, this.backendAPI);
    }

    public String getAtmId() {
        return atmId;
    }

    public State getState() {
        return state;
    }

    public void changeATMState(State state) {
        UpdateATMStateDTO updateATMStateDTO = new UpdateATMStateDTO(atmId, state.getState());
        this.backendAPI.updateATMState(updateATMStateDTO);
        this.state = state;
    }
}
