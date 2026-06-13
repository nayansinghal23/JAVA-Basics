package DecoratorDesignPattern.CofeeDecorator.decorators;

import DecoratorDesignPattern.CofeeDecorator.Coffee;

public abstract class Decorator implements Coffee {
    private Coffee coffee;

    public Decorator(Coffee coffee) {
        this.coffee = coffee;
    }

    @Override
    public String getDescription() {
        return coffee.getDescription();
    }

    @Override
    public double getCost() {
        return coffee.getCost();
    }
}
