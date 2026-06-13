package DecoratorDesignPattern.CofeeDecorator;

import DecoratorDesignPattern.CofeeDecorator.decorators.MilkDecorator;
import DecoratorDesignPattern.CofeeDecorator.decorators.VanillaDecorator;

public class Main {
    public static void main(String[] args) {
        Coffee coffee = new Espresso();
        coffee = new MilkDecorator(coffee);
        coffee = new VanillaDecorator(coffee);
        System.out.println(coffee.getDescription());
        System.out.println(coffee.getCost());
    }
}
