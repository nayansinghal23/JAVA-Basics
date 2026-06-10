import java.util.List;
import java.util.Map;

public class Pizza {
    private final PizzaType pizzaType;
    private final List<ToppingsType> toppings;
    private final Map<ToppingsType, Integer> toppingsRegistry;
    private final Map<PizzaType, Integer> pizzaTypeRegistry;

    public Pizza(PizzaBuilder pizzaBuilder) {
        pizzaType = pizzaBuilder.getPizzaType();
        toppingsRegistry = new PizzaRegistry().getToppingsRegistry();
        pizzaTypeRegistry = new PizzaRegistry().getPizzaTypeRegistry();
        toppings = pizzaBuilder.getToppings();
    }

    public List<ToppingsType> getToppings() {
        return this.toppings;
    }

    public void printReceipt() {
        int total = pizzaTypeRegistry.get(pizzaType);
        for(ToppingsType topping: toppings) {
            int price = toppingsRegistry.get(topping);
            System.out.println(topping + " = " + price);
            total += price;
        }
        
        System.out.println("Total = " + total);
    }
}
