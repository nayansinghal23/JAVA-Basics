package DecoratorDesignPattern.MovieStreaming.factories;

import DecoratorDesignPattern.MovieStreaming.streaming.prime.PrimeMovie;
import DecoratorDesignPattern.MovieStreaming.streaming.prime.PrimeSeries;
import DecoratorDesignPattern.MovieStreaming.streaming.prime.PrimeDocumentry;

public class PrimeFactory implements ProviderInterface {
    @Override
    public void showMovies() {
        PrimeMovie primeMovie = new PrimeMovie();
        primeMovie.playMovie();
    }

    @Override
    public void showSeries() {
        PrimeSeries primeSeries = new PrimeSeries();
        primeSeries.playSeries();
    }   

    @Override
    public void showDocumentary() {
        PrimeDocumentry primeDocumentry = new PrimeDocumentry();
        primeDocumentry.playDocumentry();
    }
}
