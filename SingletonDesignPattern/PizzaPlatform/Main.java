package SingletonDesignPattern.PizzaPlatform;

public class Main {
    public static void main(String[] args) {
        Pizza pizza1 = PizzaFactory.create(PizzaType.FARMHOUSE).build();
        Pizza pizza2 = PizzaFactory.create(PizzaType.FARMHOUSE).build();
        Pizza pizza3 = PizzaFactory.create(PizzaType.VEG).build();
        pizza2.printOrdersList();
    }
}
