package DecoratorDesignPattern.ComputerStore.builder;

import java.util.List;

import DecoratorDesignPattern.ComputerStore.enums.ComputerType;
import DecoratorDesignPattern.ComputerStore.enums.Additionals;
import DecoratorDesignPattern.ComputerStore.enums.FamilyType;

public class Computer {
    private final ComputerType computerType;
    private final FamilyType familyType;
    private final List<Additionals> additionals;
    
    public Computer(ComputerBuilder builder) {
        computerType = builder.getComputerType();
        familyType = builder.getFamilyType();
        additionals = builder.getAdditionals();
    }

    public int calculateCharges() {
        int base = 100000; // assuming to be fixed, to be implemented via Registy.
        return base;
    }
}
