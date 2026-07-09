public class DispensingState implements VendingState {
    @Override
    public void next(VendingContext context) {
        dispense();
        context.setState(new NoMoneyState());
    }

    private void dispense() {
        System.out.println("Dispensing your selected product");
    }
}
