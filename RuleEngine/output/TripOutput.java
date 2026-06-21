package RuleEngine.output;

import RuleEngine.enums.TripValidationStatus;

public class TripOutput {
    private final TripValidationStatus status;
    private final String reason;

    public TripOutput(TripValidationStatus status, String reason) {
        this.status = status;
        this.reason = reason;
    }

    public TripValidationStatus getStatus() {
        return status;
    }

    public String getReason() {
        return reason;
    }
}
