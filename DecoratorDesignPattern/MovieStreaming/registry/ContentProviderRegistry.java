package DecoratorDesignPattern.MovieStreaming.registry;

import java.util.HashMap;
import java.util.Map;

import DecoratorDesignPattern.MovieStreaming.enums.Plans;

public class ContentProviderRegistry {
    private final Map<Plans, Integer> planRegistry;
    private static ContentProviderRegistry instance;

    private ContentProviderRegistry() {
        planRegistry = new HashMap<>();
        seedPlanRegistry();
    }

    public static ContentProviderRegistry getInstance() {
        if(instance == null) instance = new ContentProviderRegistry();
        return instance;
    }

    private void seedPlanRegistry() {
        planRegistry.put(Plans.BASIC, 199);
        planRegistry.put(Plans.STANDARD, 499);
        planRegistry.put(Plans.PREMIUM, 799);
    }

    public int getPlanRevenue(Plans plan) {
        return planRegistry.getOrDefault(plan, 0);
    }
}
