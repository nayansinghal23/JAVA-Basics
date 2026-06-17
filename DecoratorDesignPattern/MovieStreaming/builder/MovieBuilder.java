package DecoratorDesignPattern.MovieStreaming.builder;

import DecoratorDesignPattern.MovieStreaming.enums.Plans;
import DecoratorDesignPattern.MovieStreaming.enums.Providers;

public class MovieBuilder {
    private final Providers provider;
    private final Plans plan;

    public MovieBuilder(Providers provider, Plans plan) {
        this.provider = provider;
        this.plan = plan;
    }

    public Providers getProvider() {
        return provider;
    }

    public Plans getPlan() {
        return plan;
    }

    public Movie build() {
        return new Movie(this);
    }
}
