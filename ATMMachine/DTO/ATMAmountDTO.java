package ATMMachine.DTO;

public class ATMAmountDTO {
    private final String atmId;

    public ATMAmountDTO(String atmId) {
        this.atmId = atmId;
    }

    public String getAtmId() {
        return atmId;
    }
}
