public class OutOfStockState implements VendingState {
    @Override
    public void next(VendingContext context) {
        ejectMoney();
        context.setState(new NoMoneyState());
    }

    private void ejectMoney() {
        System.out.println("Requesting a refund");
    }
}
