package SOLID.FactoryPattern;

public class CoffeeProcessor {
    public Coffee prepareCoffee(String coffeeType) {
        CoffeeFactory coffeeFactory = new CoffeeFactory();
        return coffeeFactory.prepareCoffee(coffeeType);
    }
}
