package DecoratorDesignPattern.MovieStreaming.streaming.netflix;

import DecoratorDesignPattern.MovieStreaming.streaming.Movie;

public class NetflixMovie implements Movie {
    @Override
    public void playMovie() {
        System.out.println("Playing movie from Netflix");
    }
}
