package DecoratorDesignPattern.MovieStreaming.decorators;

import DecoratorDesignPattern.MovieStreaming.builder.MovieInterface;

public class OfflineDownloadDecorator extends Decorator {
    public OfflineDownloadDecorator(MovieInterface movieInterface) {
        super(movieInterface);
    }

    @Override
    public int generateRevenue() {
        return super.generateRevenue() + 100;
    }
}
