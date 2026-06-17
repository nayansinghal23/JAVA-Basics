package DecoratorDesignPattern.MovieStreaming.factories;

import DecoratorDesignPattern.MovieStreaming.streaming.hotstar.HotstarMovie;
import DecoratorDesignPattern.MovieStreaming.streaming.hotstar.HotstarSeries;
import DecoratorDesignPattern.MovieStreaming.streaming.hotstar.HotstarDocumentry;

public class HotstarFactory implements ProviderInterface {
    @Override
    public void showMovies() {
        HotstarMovie hotstarMovie = new HotstarMovie();
        hotstarMovie.playMovie();
    }

    @Override
    public void showSeries() {
        HotstarSeries hotstarSeries = new HotstarSeries();
        hotstarSeries.playSeries();
    }

    @Override
    public void showDocumentary() {
        HotstarDocumentry hotstarDocumentry = new HotstarDocumentry();
        hotstarDocumentry.playDocumentry();
    }
}
