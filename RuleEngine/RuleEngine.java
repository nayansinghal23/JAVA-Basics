package RuleEngine;

import java.util.List;

import RuleEngine.expenses.Expense;
import RuleEngine.enums.ExpenseValidationStatus;
import RuleEngine.enums.TripValidationStatus;
import RuleEngine.output.ExpenseOutput;
import RuleEngine.output.TripOutput;
import RuleEngine.rules.adaptors.ExpenseAdaptor;
import RuleEngine.rules.adaptors.TripAdaptor;
import RuleEngine.rules.registry.RuleRegistry;

public class RuleEngine {
    private final RuleRegistry ruleRegistry;

    public RuleEngine() {
        ruleRegistry = new RuleRegistry();
    }

    public void validateTrip(List<Expense> expenses) {
        // Validate expenses
        for(Expense expense : expenses) {
            List<ExpenseAdaptor> adaptors = ruleRegistry.getExpenseRule(expense.getExpenseType());
            for(ExpenseAdaptor adaptor : adaptors) {
                ExpenseOutput output = adaptor.validate(expense);
                if(output.getStatus() == ExpenseValidationStatus.REJECTED) {
                    System.out.println(output.getStatus() + " " + output.getReason());
                }
            }
        }
        // Validate trip
        List<TripAdaptor> tripAdaptors = ruleRegistry.getTripRule(expenses.get(0).getTripId());
        for(TripAdaptor adaptor : tripAdaptors) {
            TripOutput output = adaptor.validate(expenses);
            System.out.println(output.getStatus() + " " + output.getReason());
        }
    }
}
