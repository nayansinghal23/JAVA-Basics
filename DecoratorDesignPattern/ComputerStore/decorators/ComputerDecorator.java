package DecoratorDesignPattern.ComputerStore.decorators;

import DecoratorDesignPattern.ComputerStore.builder.ComputerComponent;

public abstract class ComputerDecorator implements ComputerComponent {
    private ComputerComponent computerComponent;

    public ComputerDecorator(ComputerComponent computerComponent) {
        this.computerComponent = computerComponent;
    }

    @Override
    public int calculateCharges() {
        return computerComponent.calculateCharges();
    }
}
