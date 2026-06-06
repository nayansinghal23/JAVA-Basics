package BuilderDesignPattern.PizzaBuilder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Pizza {
    // Required
    private PizzaSize size;
    // Optional
    private List<PizzaTopings> topings;
    
    private final Map<PizzaSize, Integer> basePriceRegistry;
    private final Map<PizzaTopings, Integer> topingPriceRegistry;

    public Pizza(PizzaBuilder pizzaBuilder) {
        this.size = pizzaBuilder.getSize();
        this.topings = pizzaBuilder.getTopings();

        this.basePriceRegistry = new HashMap<>();
        this.seedBasePriceRegistry();

        this.topingPriceRegistry = new HashMap<>();
        this.seedTopingPriceRegistry();
    }

    public PizzaSize getSize() {
        return this.size;
    }

    public List<PizzaTopings> getTopings() {
        return this.topings;
    }

    private void seedBasePriceRegistry() {
        basePriceRegistry.put(PizzaSize.SMALL, 100);
        basePriceRegistry.put(PizzaSize.MEDIUM, 200);
        basePriceRegistry.put(PizzaSize.LARGE, 300);
    }

    private void seedTopingPriceRegistry() {
        topingPriceRegistry.put(PizzaTopings.CHEESE, 30);
        topingPriceRegistry.put(PizzaTopings.MUSHROOM, 20);
        topingPriceRegistry.put(PizzaTopings.OLIVERS, 25);
        topingPriceRegistry.put(PizzaTopings.PANEER, 40);
        topingPriceRegistry.put(PizzaTopings.EXTRA_SAUCE, 10);
    }

    public int calculatePrice() {
        int price = basePriceRegistry.get(size);

        for(PizzaTopings toping: topings) price += topingPriceRegistry.get(toping);
        return price;
    }
}
