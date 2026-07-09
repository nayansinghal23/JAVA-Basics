public class NoMoneyState implements VendingState {
    @Override
    public void next(VendingContext context) {
        insertMoney();
        context.setState(new HasMoneyState());
    }

    private void insertMoney() {
        System.out.println("Money has been inserted.");
    }
}
