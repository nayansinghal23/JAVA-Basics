package DecoratorDesignPattern.MovieStreaming.streaming.hotstar;

import DecoratorDesignPattern.MovieStreaming.streaming.Documentry;

public class HotstarDocumentry implements Documentry {
    @Override
    public void playDocumentry() {
        System.out.println("Playing documentry from Hotstar");
    }
}
