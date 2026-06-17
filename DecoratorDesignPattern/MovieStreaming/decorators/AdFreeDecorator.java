package DecoratorDesignPattern.MovieStreaming.decorators;

import DecoratorDesignPattern.MovieStreaming.builder.MovieInterface;

public class AdFreeDecorator extends Decorator {
    public AdFreeDecorator(MovieInterface movieInterface) {
        super(movieInterface);
    }

    @Override
    public int generateRevenue() {
        return super.generateRevenue() + 120;
    }
}
