package DecoratorDesignPattern.ComputerStore.decorators;

import DecoratorDesignPattern.ComputerStore.builder.ComputerComponent;

public class InsuranceDecorator extends ComputerDecorator {
    public InsuranceDecorator(ComputerComponent computerComponent) {
        super(computerComponent);
    }

    @Override
    public int calculateCharges() {
        return super.calculateCharges() + 3000;
    }
}
