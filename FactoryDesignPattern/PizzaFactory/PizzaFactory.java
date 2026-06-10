public class PizzaFactory {
    public static PizzaBuilder create(PizzaType pizzaType) {
        if(pizzaType == PizzaType.CHEESE_BURST) return new CheeseBurstPizza().create();
        else if(pizzaType == PizzaType.FARMHOUSE) return new FarmhousePizza().create();
        else if(pizzaType == PizzaType.VEG) return new VegPizza().create();
        throw new IllegalArgumentException("Pizza type not supported.");
    }
}
