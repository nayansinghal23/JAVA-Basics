package BuilderDesignPattern.PizzaBuilder;

public class Main {
    public void main() {
        Pizza pizza = new PizzaBuilder(PizzaSize.LARGE)
                    .addCheese()
                    .addPaneer()
                    .build();
        System.out.println(pizza.calculatePrice());
    }
}
