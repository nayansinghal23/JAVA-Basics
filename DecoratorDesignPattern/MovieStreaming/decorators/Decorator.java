package DecoratorDesignPattern.MovieStreaming.decorators;

import DecoratorDesignPattern.MovieStreaming.builder.MovieInterface;

public abstract class Decorator implements MovieInterface {
    private MovieInterface movieInterface;

    public Decorator(MovieInterface movieInterface) {
        this.movieInterface = movieInterface;
    }

    @Override
    public int generateRevenue() {
        return movieInterface.generateRevenue();
    }
}
