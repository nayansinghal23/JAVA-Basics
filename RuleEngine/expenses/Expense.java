package RuleEngine.expenses;

import RuleEngine.enums.ExpenseType;

public class Expense {
    private final String expense_id;
    private final String trip_id;
    private final Integer amount_usd;
    private final ExpenseType expense_type;
    private final String vendor_name;
    
    public Expense(ExpenseBuilder builder) {
        expense_id = builder.getExpenseId();
        trip_id = builder.getTripId();
        amount_usd = builder.getAmountUSD();
        expense_type = builder.getExpenseType();
        vendor_name = builder.getVendorName();
    }

    public String getExpenseId() {
        return expense_id;
    }

    public String getTripId() {
        return trip_id;
    }

    public Integer getAmountUSD() {
        return amount_usd;
    }

    public ExpenseType getExpenseType() {
        return expense_type;
    }

    public String getVendorName() {
        return vendor_name;
    }
}
