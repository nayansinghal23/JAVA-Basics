package RuleEngine.expenses;

import RuleEngine.enums.ExpenseType;

public class ExpenseBuilder {
    private final String expense_id;
    private final String trip_id;
    private final Integer amount_usd;
    private final ExpenseType expense_type;
    private final String vendor_name;

    public ExpenseBuilder(String expense_id, String trip_id, Integer amount_usd, ExpenseType expense_type, String vendor_name) {
        this.expense_id = expense_id;
        this.trip_id = trip_id;
        this.amount_usd = amount_usd;
        this.expense_type = expense_type;
        this.vendor_name = vendor_name;
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

    // Setters

    public Expense build() {
        return new Expense(this);
    }
}
