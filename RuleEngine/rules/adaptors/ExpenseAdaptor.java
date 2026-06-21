package RuleEngine.rules.adaptors;

import RuleEngine.expenses.Expense;
import RuleEngine.output.ExpenseOutput;

public interface ExpenseAdaptor {
    ExpenseOutput validate(Expense expense);
}
