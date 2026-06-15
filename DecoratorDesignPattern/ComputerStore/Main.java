package DecoratorDesignPattern.ComputerStore;

import DecoratorDesignPattern.ComputerStore.builder.Computer;
import DecoratorDesignPattern.ComputerStore.enums.ComputerType;
import DecoratorDesignPattern.ComputerStore.enums.FamilyType;
import DecoratorDesignPattern.ComputerStore.factories.ComputerFactory;

public class Main {
    public static void main(String[] args) {
        Computer computer = ComputerFactory.createComputer(FamilyType.AMD, ComputerType.GAMING_PC).addExtraRam().addRGBLighting().build();
        System.out.println(computer.calculateCharges());
    }
}
