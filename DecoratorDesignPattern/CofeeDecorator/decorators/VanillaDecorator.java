package DecoratorDesignPattern.CofeeDecorator.decorators;

import DecoratorDesignPattern.CofeeDecorator.Coffee;

public class VanillaDecorator extends Decorator {
    public VanillaDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Vanilla";
    }

    @Override
    public double getCost() {
        return super.getCost() + 0.75;
    }
}
