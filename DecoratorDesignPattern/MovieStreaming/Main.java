package DecoratorDesignPattern.MovieStreaming;

import DecoratorDesignPattern.MovieStreaming.builder.MovieInterface;
import DecoratorDesignPattern.MovieStreaming.decorators.OfflineDownloadDecorator;
import DecoratorDesignPattern.MovieStreaming.decorators.FourKStreamingDecorator;
import DecoratorDesignPattern.MovieStreaming.enums.Plans;
import DecoratorDesignPattern.MovieStreaming.enums.Providers;
import DecoratorDesignPattern.MovieStreaming.factories.MovieFactory;

public class Main {
    public static void main(String[] args) {
        MovieInterface movie = MovieFactory.watchMovie(Providers.PRIME, Plans.STANDARD).build();
        movie = new OfflineDownloadDecorator(movie);
        movie = new FourKStreamingDecorator(movie);
        System.out.println(movie.generateRevenue());
    }
}
