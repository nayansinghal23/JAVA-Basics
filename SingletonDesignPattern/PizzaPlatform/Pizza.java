package SingletonDesignPattern.PizzaPlatform;

import java.util.List;

public class Pizza {
    private final List<TopingType> list;
    private final PizzaType pizzaType;
    private final PizzaRegistry pizzaRegistry;

    public Pizza(PizzaBuilder builder) {
        list = builder.getList();
        pizzaType = builder.getPizzaType();
        pizzaRegistry = PizzaRegistry.getInstance();
        pizzaRegistry.setPizzaTypeCount(pizzaType);
    }

    public void printOrdersList() {
        int total = 0;
        for(PizzaType type : pizzaRegistry.getList()) {
            int count = pizzaRegistry.getPizzaTypeCount(type);
            total += count;
            System.out.println(type + " = " + count);
        }
        System.out.println("Total orders = " + total);
    }
}
