package DecoratorDesignPattern.MovieStreaming.streaming.netflix;

import DecoratorDesignPattern.MovieStreaming.streaming.Series;

public class NetflixSeries implements Series {
    @Override
    public void playSeries() {
        System.out.println("Playing series from Netflix");
    }
}
