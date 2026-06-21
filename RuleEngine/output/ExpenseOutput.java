package RuleEngine.output;

import RuleEngine.enums.ExpenseValidationStatus;

public class ExpenseOutput {
    private final ExpenseValidationStatus status;
    private final String reason;

    public ExpenseOutput(ExpenseValidationStatus status, String reason) {
        this.status = status;
        this.reason = reason;
    }

    public ExpenseValidationStatus getStatus() {
        return status;
    }

    public String getReason() {
        return reason;
    }
}
