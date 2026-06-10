public class Main {
    public void main() {
        Pizza pizza = PizzaFactory.create(PizzaType.FARMHOUSE).addCheese().addPaneer().build();
        pizza.printReceipt();
    }
}
