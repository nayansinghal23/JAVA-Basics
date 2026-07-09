public class HasMoneyState implements VendingState {
    @Override
    public void next(VendingContext context) {
        if(inventoryCheck()) {
            selectProduct();
            context.setState(new DispensingState());
        }
        else {
            System.out.println("No product available");
            context.setState(new OutOfStockState());
        }
    }

    private boolean inventoryCheck() {
        System.out.println("Checking inventory...");
        return false;
    }
    
    private void selectProduct() {
        System.out.println("Product selected");
    }
}
