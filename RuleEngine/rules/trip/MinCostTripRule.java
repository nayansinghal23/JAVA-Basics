package RuleEngine.rules.trip;

import java.util.List;

import RuleEngine.expenses.Expense;
import RuleEngine.enums.TripValidationStatus;
import RuleEngine.output.TripOutput;
import RuleEngine.rules.adaptors.TripAdaptor;

public class MinCostTripRule implements TripAdaptor {
    private final Integer threshold;

    public MinCostTripRule(int threshold) {
        this.threshold = threshold;
    }

    @Override
    public TripOutput validate(List<Expense> expenses) {
        int total = 0;
        for(Expense expense : expenses) total += expense.getAmountUSD();
        if(total > threshold) {
            return new TripOutput(TripValidationStatus.VIOLATIONS, "Trip " + expenses.get(0).getTripId() + " cost exceeds $" + threshold);
        }
        return new TripOutput(TripValidationStatus.OK, "Trip cost is under $" + threshold);
    }
}
