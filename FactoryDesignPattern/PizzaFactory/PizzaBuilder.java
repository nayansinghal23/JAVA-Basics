import java.util.ArrayList;
import java.util.List;

public class PizzaBuilder {
    private final List<ToppingsType> toppings;
    private final PizzaType pizzaType;

    public PizzaBuilder(PizzaType pizzaType) {
        this.toppings = new ArrayList<>();
        this.pizzaType = pizzaType;
    }

    public List<ToppingsType> getToppings() {
        return this.toppings;
    }

    public PizzaType getPizzaType() {
        return this.pizzaType;
    }

    public PizzaBuilder addCheese() {
        this.toppings.add(ToppingsType.EXTRA_CHEESE);
        return this;
    }

    public PizzaBuilder addPaneer() {
        this.toppings.add(ToppingsType.PANEER);
        return this;
    }

    public PizzaBuilder addSauce() {
        this.toppings.add(ToppingsType.EXTRA_SAUCE);
        return this;
    }

    public PizzaBuilder addMushroom() {
        this.toppings.add(ToppingsType.MUSHROOM);
        return this;
    }
    
    public PizzaBuilder addOlivers() {
        this.toppings.add(ToppingsType.OLIVERS);
        return this;
    }

    public Pizza build() {
        return new Pizza(this);
    }
}
