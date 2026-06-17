package DecoratorDesignPattern.MovieStreaming.decorators;

import DecoratorDesignPattern.MovieStreaming.builder.MovieInterface;

public class MultipleDeviceDecorator extends Decorator {
    public MultipleDeviceDecorator(MovieInterface movieInterface) {
        super(movieInterface);
    }

    @Override
    public int generateRevenue() {
        return super.generateRevenue() + 200;
    }   
}
