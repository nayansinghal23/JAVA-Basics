package RuleEngine.rules.registry;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import RuleEngine.enums.ExpenseType;
import RuleEngine.rules.adaptors.ExpenseAdaptor;
import RuleEngine.rules.adaptors.TripAdaptor;
import RuleEngine.rules.expense.MinAmountRule;
import RuleEngine.rules.expense.NotAllowedRule;
import RuleEngine.rules.trip.MinCostExpenseTypeRule;
import RuleEngine.rules.trip.MinCostTripRule;

public class RuleRegistry {
    private final Map<ExpenseType, List<ExpenseAdaptor>> expenseRuleRegistry;
    private final Map<String, List<TripAdaptor>> tripRuleRegistry;

    public RuleRegistry() {
        expenseRuleRegistry = new HashMap<>();
        tripRuleRegistry = new HashMap<>();
        seedExpenseRules();
        seedTripRules();
    }

    private void seedExpenseRules() {
        expenseRuleRegistry.put(ExpenseType.RESTAURANT, 
            new ArrayList<>(List.of(new MinAmountRule(75), new MinAmountRule(250)))
        );
        expenseRuleRegistry.put(ExpenseType.AIRFARE, new ArrayList<>(List.of(new NotAllowedRule(), new MinAmountRule(250))));
        expenseRuleRegistry.put(ExpenseType.ENTERTAINMENT, new ArrayList<>(List.of(new NotAllowedRule(), new MinAmountRule(250))));
        expenseRuleRegistry.put(ExpenseType.SUPPLIES, new ArrayList<>(List.of(new MinAmountRule(250))));
        expenseRuleRegistry.put(ExpenseType.HOTEL, new ArrayList<>(List.of(new MinAmountRule(250))));
    }

    private void seedTripRules() {
        tripRuleRegistry.put("trip1", new ArrayList<>(List.of(new MinCostTripRule(2000), new MinCostExpenseTypeRule(ExpenseType.RESTAURANT, 1000))));
    }

    public List<ExpenseAdaptor> getExpenseRule(ExpenseType expenseType) {
        return expenseRuleRegistry.getOrDefault(expenseType, new ArrayList<>());
    }

    public List<TripAdaptor> getTripRule(String tripId) {
        return tripRuleRegistry.getOrDefault(tripId, new ArrayList<>());
    }
}
