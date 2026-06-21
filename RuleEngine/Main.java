package RuleEngine;

import java.util.ArrayList;
import java.util.List;

import RuleEngine.enums.ExpenseType;
import RuleEngine.expenses.Expense;
import RuleEngine.expenses.ExpenseBuilder;

public class Main {
    public static void main() {
        List<Expense> expenses = new ArrayList<>();
        expenses.add(new ExpenseBuilder("001", "trip1", 80, ExpenseType.RESTAURANT, "Outback Roadhouse").build());
        expenses.add(new ExpenseBuilder("002", "trip1", 120, ExpenseType.SUPPLIES, "Staples").build());
        expenses.add(new ExpenseBuilder("003", "trip1", 199, ExpenseType.AIRFARE, "Delta Airlines").build());
        expenses.add(new ExpenseBuilder("004", "trip1", 260, ExpenseType.HOTEL, "Marriott").build());
        expenses.add(new ExpenseBuilder("005", "trip1", 70, ExpenseType.RESTAURANT, "Chipotle").build());
        expenses.add(new ExpenseBuilder("006", "trip1", 40, ExpenseType.ENTERTAINMENT, "AMC Theatres").build());

        RuleEngine ruleEngine = new RuleEngine();
        ruleEngine.validateTrip(expenses);
    }
}
