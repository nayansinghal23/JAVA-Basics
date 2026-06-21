package DecoratorDesignPattern.MovieStreaming.builder;

import DecoratorDesignPattern.MovieStreaming.analytics.AnalyticService;
import DecoratorDesignPattern.MovieStreaming.enums.Plans;
import DecoratorDesignPattern.MovieStreaming.enums.Providers;
import DecoratorDesignPattern.MovieStreaming.registry.ContentProviderRegistry;

public class Movie implements MovieInterface {
    private final Providers provider;
    private final Plans plan;
    private final ContentProviderRegistry contentProviderRegistry;
    
    public Movie(MovieBuilder builder) {
        this.provider = builder.getProvider();
        this.plan = builder.getPlan();
        contentProviderRegistry = ContentProviderRegistry.getInstance();
        // Singleton pattern for AnalyticService
        AnalyticService analyticService = AnalyticService.getInstance();
        analyticService.recordSubscription(provider);
    }

    @Override
    public int generateRevenue() {
        return contentProviderRegistry.getPlanRevenue(plan);
    }
}
