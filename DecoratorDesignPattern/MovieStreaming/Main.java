package DecoratorDesignPattern.MovieStreaming;

import DecoratorDesignPattern.MovieStreaming.analytics.AnalyticService;
import DecoratorDesignPattern.MovieStreaming.builder.MovieInterface;
import DecoratorDesignPattern.MovieStreaming.decorators.OfflineDownloadDecorator;
import DecoratorDesignPattern.MovieStreaming.decorators.FourKStreamingDecorator;
import DecoratorDesignPattern.MovieStreaming.enums.Plans;
import DecoratorDesignPattern.MovieStreaming.enums.Providers;
import DecoratorDesignPattern.MovieStreaming.factories.MovieFactory;

public class Main {
    public static void main(String[] args) {
        MovieInterface movie1 =
        MovieFactory.watchMovie(Providers.PRIME, Plans.STANDARD).build();
        movie1 = new OfflineDownloadDecorator(movie1);
        movie1 = new FourKStreamingDecorator(movie1);

        System.out.println("----------------------------------");
        
        MovieInterface movie2 =
        MovieFactory.watchMovie(Providers.NETFLIX, Plans.BASIC).build();
        
        System.out.println("----------------------------------");
        
        MovieInterface movie3 =
        MovieFactory.watchMovie(Providers.PRIME, Plans.PREMIUM).build();
        
        System.out.println("----------------------------------");
        
        AnalyticService analyticService = AnalyticService.getInstance();
        analyticService.printTotalSubscriptions();
    }
}
