package DecoratorDesignPattern.MovieStreaming.analytics;

import java.util.HashMap;
import java.util.Map;

import DecoratorDesignPattern.MovieStreaming.enums.Providers;

public class AnalyticService {
    private static AnalyticService instance;
    private final Map<Providers, Integer> providerRegistry;

    private AnalyticService() {
        providerRegistry = new HashMap<>();
    }

    public static AnalyticService getInstance() {
        if(instance == null) instance = new AnalyticService();
        return instance;
    }

    public void recordSubscription(Providers provider) {
        providerRegistry.put(provider, providerRegistry.getOrDefault(provider, 0) + 1);
    }

    public void printTotalSubscriptions() {
        for(Providers provider : providerRegistry.keySet()) {
            System.out.println(provider + " = " + providerRegistry.get(provider));
        }
    }
}
