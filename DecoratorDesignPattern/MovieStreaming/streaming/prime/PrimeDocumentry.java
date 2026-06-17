package DecoratorDesignPattern.MovieStreaming.streaming.prime;

import DecoratorDesignPattern.MovieStreaming.streaming.Documentry;

public class PrimeDocumentry implements Documentry {
    @Override
    public void playDocumentry() {
        System.out.println("Playing documentry from Prime");
    }
}
