package RuleEngine.rules.trip;

import java.util.List;

import RuleEngine.enums.ExpenseType;
import RuleEngine.enums.TripValidationStatus;
import RuleEngine.expenses.Expense;
import RuleEngine.output.TripOutput;
import RuleEngine.rules.adaptors.TripAdaptor;

public class MinCostExpenseTypeRule implements TripAdaptor {
    private final ExpenseType expenseType;
    private final Integer threshold;

    public MinCostExpenseTypeRule(ExpenseType expenseType, int threshold) {
        this.expenseType = expenseType;
        this.threshold = threshold;
    }

    @Override
    public TripOutput validate(List<Expense> expenses) {
        int total = 0;
        for(Expense expense : expenses) {
            if(expense.getExpenseType() == expenseType) {
                total += expense.getAmountUSD();
            }
        }
        if(total > threshold) {
            return new TripOutput(TripValidationStatus.VIOLATIONS, "Trip " + expenses.get(0).getTripId() + " " + expenseType + " expense exceeds $" + threshold);
        }
        return new TripOutput(TripValidationStatus.OK, "Trip " + expenses.get(0).getTripId() + " " + expenseType + " expense is under $" + threshold);
    }
}
