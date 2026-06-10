public class VegPizza implements PizzaTypeInterface {
    @Override
    public PizzaBuilder create() {
        return new PizzaBuilder(PizzaType.VEG);
    }
}
