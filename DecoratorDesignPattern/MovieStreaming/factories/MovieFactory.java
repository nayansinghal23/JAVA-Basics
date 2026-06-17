package DecoratorDesignPattern.MovieStreaming.factories;

import DecoratorDesignPattern.MovieStreaming.builder.MovieBuilder;
import DecoratorDesignPattern.MovieStreaming.enums.Plans;
import DecoratorDesignPattern.MovieStreaming.enums.Providers;

public class MovieFactory {
    public static MovieBuilder watchMovie(Providers provider, Plans plan) {
        ProviderInterface providerInterface = null;
        if(provider == Providers.NETFLIX) providerInterface = new NetflixFactory();
        else if(provider == Providers.PRIME) providerInterface = new PrimeFactory();
        else if(provider == Providers.HOTSTAR) providerInterface = new HotstarFactory();
        else throw new IllegalArgumentException("Provider not supported!!!");

        providerInterface.showMovies();
        providerInterface.showSeries();
        providerInterface.showDocumentary();

        return new MovieBuilder(provider, plan);
    }
}
