public class FarmhousePizza implements PizzaTypeInterface {
    @Override
    public PizzaBuilder create() {
        return new PizzaBuilder(PizzaType.FARMHOUSE);
    }
}
