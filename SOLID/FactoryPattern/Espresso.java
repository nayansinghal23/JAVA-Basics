package SOLID.FactoryPattern;

public class Espresso implements Coffee {
    @Override
    public void boil() {
        System.out.println("Boiling Espresso");
    }

    @Override
    public void freeze() {
        System.out.println("Freezing Espresso");
    }
    
    @Override
    public void brew() {
        System.out.println("Brewing Espresso");
    }
}
