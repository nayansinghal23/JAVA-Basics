package SOLID.FactoryPattern;

public class CoffeeFactory {
    public Coffee prepareCoffee(String coffeeType) {
        Coffee coffee;
        if(coffeeType.equals("Espresso")) {
            coffee = new Espresso();
        } else if(coffeeType.equals("Latte")) {
            coffee = new Latte();
        } else if(coffeeType.equals("Cappucino")) {
            coffee = new Cappucino();
        } else {
            throw new IllegalArgumentException("Invalid coffee type");
        }
        return coffee;
    }
}
