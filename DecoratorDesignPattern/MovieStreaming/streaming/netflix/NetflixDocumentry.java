package DecoratorDesignPattern.MovieStreaming.streaming.netflix;

import DecoratorDesignPattern.MovieStreaming.streaming.Documentry;

public class NetflixDocumentry implements Documentry {
    @Override
    public void playDocumentry() {
        System.out.println("Playing documentry from Netflix");
    }
}
