package BuilderDesignPattern.PizzaBuilder;

import java.util.ArrayList;
import java.util.List;

public class PizzaBuilder {
    // Required
    private PizzaSize size;
    // Optional
    private List<PizzaTopings> topings;

    public PizzaBuilder(PizzaSize size) {
        this.size = size;
        this.topings = new ArrayList<>();
    }

    public PizzaSize getSize() {
        return this.size;
    }

    public List<PizzaTopings> getTopings() {
        return this.topings;
    }

    public PizzaBuilder setSize(PizzaSize size) {
        this.size = size;
        return this;
    }

    public PizzaBuilder addCheese() {
        this.topings.add(PizzaTopings.CHEESE);
        return this;
    }

    public PizzaBuilder addPaneer() {
        this.topings.add(PizzaTopings.PANEER);
        return this;
    }

    public PizzaBuilder addOlivers() {
        this.topings.add(PizzaTopings.OLIVERS);
        return this;
    }

    public PizzaBuilder addMushroom() {
        this.topings.add(PizzaTopings.MUSHROOM);
        return this;
    }

    public PizzaBuilder addExtraSauce() {
        this.topings.add(PizzaTopings.EXTRA_SAUCE);
        return this;
    }

    public Pizza build() {
        return new Pizza(this);
    }
}
