package DecoratorDesignPattern.MovieStreaming.factories;

import DecoratorDesignPattern.MovieStreaming.streaming.netflix.NetflixMovie;
import DecoratorDesignPattern.MovieStreaming.streaming.netflix.NetflixSeries;
import DecoratorDesignPattern.MovieStreaming.streaming.netflix.NetflixDocumentry;

public class NetflixFactory implements ProviderInterface {
    @Override
    public void showMovies() {
        NetflixMovie netflixMovie = new NetflixMovie();
        netflixMovie.playMovie();
    }

    @Override
    public void showSeries() {
        NetflixSeries netflixSeries = new NetflixSeries();
        netflixSeries.playSeries();
    }
    
    @Override
    public void showDocumentary() {
        NetflixDocumentry netflixDocumentry = new NetflixDocumentry();
        netflixDocumentry.playDocumentry();
    }
}
