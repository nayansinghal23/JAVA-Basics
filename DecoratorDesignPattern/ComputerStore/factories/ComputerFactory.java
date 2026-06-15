package DecoratorDesignPattern.ComputerStore.factories;

import DecoratorDesignPattern.ComputerStore.builder.ComputerBuilder;
import DecoratorDesignPattern.ComputerStore.enums.ComputerType;
import DecoratorDesignPattern.ComputerStore.enums.FamilyType;

public class ComputerFactory {
    public static ComputerBuilder createComputer(FamilyType familyType, ComputerType computerType) {
        Factory factory = null;

        if(familyType == FamilyType.Intel) factory = new IntelFactory();
        else if(familyType == FamilyType.AMD) factory = new AMDFactory();
        else throw new IllegalArgumentException("Family type not supported!!!");

        factory.createCPU();
        factory.createGPU();
        factory.createMotherBoard();

        return new ComputerBuilder(computerType, familyType);
    }
}
