package DecoratorDesignPattern.ComputerStore.decorators;

import DecoratorDesignPattern.ComputerStore.builder.ComputerComponent;

public class WarrantyDecorator extends ComputerDecorator {
    public WarrantyDecorator(ComputerComponent computerComponent) {
        super(computerComponent);
    }

    @Override
    public int calculateCharges() {
        return super.calculateCharges() + 5000;
    }
}
