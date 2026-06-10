import java.util.HashMap;
import java.util.Map;

public class PizzaRegistry {
    private final Map<PizzaType, Integer> pizzaTypeRegistry;
    private final Map<ToppingsType, Integer> toppingsRegistry;

    public PizzaRegistry() {
        pizzaTypeRegistry = new HashMap<>();
        toppingsRegistry = new HashMap<>();
        this.seedPizzaTypeRegistry();
        this.seedToppingsRegistry();
    }

    private void seedToppingsRegistry() {
        toppingsRegistry.put(ToppingsType.EXTRA_CHEESE, 50);
        toppingsRegistry.put(ToppingsType.EXTRA_SAUCE, 20);
        toppingsRegistry.put(ToppingsType.OLIVERS, 30);
        toppingsRegistry.put(ToppingsType.MUSHROOM, 40);
        toppingsRegistry.put(ToppingsType.PANEER, 60);
    }

    private void seedPizzaTypeRegistry() {
        pizzaTypeRegistry.put(PizzaType.VEG, 200);
        pizzaTypeRegistry.put(PizzaType.FARMHOUSE, 300);
        pizzaTypeRegistry.put(PizzaType.CHEESE_BURST, 400);
    }

    public Map<ToppingsType, Integer> getToppingsRegistry() {
        return this.toppingsRegistry;
    }

    public Map<PizzaType, Integer> getPizzaTypeRegistry() {
        return this.pizzaTypeRegistry;
    }
}
