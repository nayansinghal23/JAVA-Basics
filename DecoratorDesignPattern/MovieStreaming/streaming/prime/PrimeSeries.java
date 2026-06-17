package DecoratorDesignPattern.MovieStreaming.streaming.prime;

import DecoratorDesignPattern.MovieStreaming.streaming.Series;

public class PrimeSeries implements Series {
    @Override
    public void playSeries() {
        System.out.println("Playing series from Prime");
    }
}
