package SOLID.FactoryPattern;

public class Cappucino implements Coffee {
    @Override
    public void boil() {
        System.out.println("Boiling Cappucino");
    }

    @Override
    public void freeze() {
        System.out.println("Freezing Cappucino");
    }
    
    @Override
    public void brew() {
        System.out.println("Brewing Cappucino");
    }
}
