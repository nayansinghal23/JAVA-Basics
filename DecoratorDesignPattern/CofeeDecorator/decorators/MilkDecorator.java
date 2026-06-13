package DecoratorDesignPattern.CofeeDecorator.decorators;

import DecoratorDesignPattern.CofeeDecorator.Coffee;

public class MilkDecorator extends Decorator {
    public MilkDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Milk";
    }

    @Override
    public double getCost() {
        return super.getCost() + 0.5;
    }
}
