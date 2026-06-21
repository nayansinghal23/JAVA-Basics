package RuleEngine.rules.expense;

import RuleEngine.enums.ExpenseType;
import RuleEngine.enums.ExpenseValidationStatus;
import RuleEngine.expenses.Expense;
import RuleEngine.output.ExpenseOutput;
import RuleEngine.rules.adaptors.ExpenseAdaptor;

public class MinAmountRule implements ExpenseAdaptor {
    private final Integer threshold;

    public MinAmountRule(int threshold) {
        this.threshold = threshold;
    }

    @Override
    public ExpenseOutput validate(Expense expense) {
        int amount = expense.getAmountUSD();
        ExpenseType expenseType = expense.getExpenseType();

        if(amount > 0 && amount <= threshold) {
            return new ExpenseOutput(ExpenseValidationStatus.APPROVED, expenseType + " expense is under $" + threshold);
        }
        return new ExpenseOutput(ExpenseValidationStatus.REJECTED, expenseType + " expense exceeds $" + threshold);
    }
}
