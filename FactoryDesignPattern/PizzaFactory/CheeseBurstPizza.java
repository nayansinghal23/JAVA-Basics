public class CheeseBurstPizza implements PizzaTypeInterface {
    @Override
    public PizzaBuilder create() {
        return new PizzaBuilder(PizzaType.CHEESE_BURST);
    }
}
