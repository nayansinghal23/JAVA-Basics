package SOLID.FactoryPattern;

public class Latte implements Coffee {
    @Override
    public void boil() {
        System.out.println("Boiling Latte");
    }

    @Override
    public void freeze() {
        System.out.println("Freezing Latte");
    }

    @Override
    public void brew() {
        System.out.println("Brewing Latte");
    }
}
