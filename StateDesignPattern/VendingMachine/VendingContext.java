public class VendingContext {
    private VendingState state;

    public VendingContext() {
        state = new NoMoneyState();
    }

    public void setState(VendingState state) {
        this.state = state;
    }

    public void next() {
        state.next(this);
    }
}
