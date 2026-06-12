package SingletonDesignPattern.PizzaPlatform;

import java.util.ArrayList;
import java.util.List;

public class PizzaBuilder {
    private final List<TopingType> list;
    private final PizzaType pizzaType;

    public PizzaBuilder(PizzaType pizzaType) {
        this.pizzaType = pizzaType;
        list = new ArrayList<>();
    }

    public List<TopingType> getList() {
        return list;
    }

    public PizzaType getPizzaType() {
        return pizzaType;
    }

    public PizzaBuilder addCheese() {
        list.add(TopingType.CHEESE);
        return this;
    }

    public PizzaBuilder addOlivers() {
        list.add(TopingType.OLIVERS);
        return this;
    }

    public PizzaBuilder addMushroom() {
        list.add(TopingType.MUSHROOM);
        return this;
    }

    public PizzaBuilder addPaneer() {
        list.add(TopingType.PANEER);
        return this;
    }

    public Pizza build() {
        return new Pizza(this);
    }
}
