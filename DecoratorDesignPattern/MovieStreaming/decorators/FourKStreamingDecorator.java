package DecoratorDesignPattern.MovieStreaming.decorators;

import DecoratorDesignPattern.MovieStreaming.builder.MovieInterface;

public class FourKStreamingDecorator extends Decorator {
    public FourKStreamingDecorator(MovieInterface movieInterface) {
        super(movieInterface);
    }

    @Override
    public int generateRevenue() {
        return super.generateRevenue() + 150;
    }
}
