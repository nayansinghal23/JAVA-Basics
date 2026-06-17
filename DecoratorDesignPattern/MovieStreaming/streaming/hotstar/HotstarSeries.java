package DecoratorDesignPattern.MovieStreaming.streaming.hotstar;

import DecoratorDesignPattern.MovieStreaming.streaming.Series;

public class HotstarSeries implements Series {
    @Override
    public void playSeries() {
        System.out.println("Playing series from Hotstar");
    }
}
