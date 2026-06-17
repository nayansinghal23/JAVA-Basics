package DecoratorDesignPattern.MovieStreaming.streaming.hotstar;

import DecoratorDesignPattern.MovieStreaming.streaming.Movie;

public class HotstarMovie implements Movie {
    @Override
    public void playMovie() {
        System.out.println("Playing movie from Hotstar");
    }
}
