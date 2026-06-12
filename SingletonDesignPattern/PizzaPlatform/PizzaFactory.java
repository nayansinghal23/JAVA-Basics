package SingletonDesignPattern.PizzaPlatform;

public class PizzaFactory {
    public static PizzaBuilder create(PizzaType pizzaType) {
        return new PizzaBuilder(pizzaType);
    }
}
