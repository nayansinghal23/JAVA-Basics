package DecoratorDesignPattern.ComputerStore;

import DecoratorDesignPattern.ComputerStore.builder.ComputerComponent;
import DecoratorDesignPattern.ComputerStore.decorators.InsuranceDecorator;
import DecoratorDesignPattern.ComputerStore.decorators.WarrantyDecorator;
import DecoratorDesignPattern.ComputerStore.enums.ComputerType;
import DecoratorDesignPattern.ComputerStore.enums.FamilyType;
import DecoratorDesignPattern.ComputerStore.factories.ComputerFactory;

public class Main {
    public static void main(String[] args) {
        ComputerComponent computer = ComputerFactory.createComputer(FamilyType.AMD, ComputerType.GAMING_PC).addExtraRam().addRGBLighting().build();
        computer = new WarrantyDecorator(
            new InsuranceDecorator(computer)
        );
        System.out.println(computer.calculateCharges());
    }
}
