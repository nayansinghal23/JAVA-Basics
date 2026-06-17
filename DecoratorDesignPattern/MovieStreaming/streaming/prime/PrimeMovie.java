package DecoratorDesignPattern.MovieStreaming.streaming.prime;

import DecoratorDesignPattern.MovieStreaming.streaming.Movie;

public class PrimeMovie implements Movie {
    @Override
    public void playMovie() {
        System.out.println("Playing movie from Prime");
    }
}
