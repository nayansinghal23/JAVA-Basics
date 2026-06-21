package RuleEngine.rules.adaptors;

import java.util.List;

import RuleEngine.expenses.Expense;
import RuleEngine.output.TripOutput;

public interface TripAdaptor {
    TripOutput validate(List<Expense> expenses);
}
