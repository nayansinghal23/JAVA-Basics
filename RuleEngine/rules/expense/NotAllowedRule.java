package RuleEngine.rules.expense;

import RuleEngine.enums.ExpenseType;
import RuleEngine.enums.ExpenseValidationStatus;
import RuleEngine.expenses.Expense;
import RuleEngine.output.ExpenseOutput;
import RuleEngine.rules.adaptors.ExpenseAdaptor;

public class NotAllowedRule implements ExpenseAdaptor {
    @Override
    public ExpenseOutput validate(Expense expense) {
        int amount = expense.getAmountUSD();
        ExpenseType expenseType = expense.getExpenseType();

        if(amount > 0) {
            return new ExpenseOutput(ExpenseValidationStatus.REJECTED, expenseType + " expenses not allowed");
        }
        return new ExpenseOutput(ExpenseValidationStatus.APPROVED, expenseType + " expenses allowed");
    }
}
