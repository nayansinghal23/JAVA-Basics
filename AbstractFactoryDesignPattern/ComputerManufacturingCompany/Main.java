package AbstractFactoryDesignPattern.ComputerManufacturingCompany;

import AbstractFactoryDesignPattern.ComputerManufacturingCompany.builder.Computer;
import AbstractFactoryDesignPattern.ComputerManufacturingCompany.enums.ComponentFamily;
import AbstractFactoryDesignPattern.ComputerManufacturingCompany.enums.ComputerType;
import AbstractFactoryDesignPattern.ComputerManufacturingCompany.factories.ComputerFactory;

public class Main {
    public static void main() {
        Computer computer1 = ComputerFactory.create(
            ComputerType.GAMING_PC,
            ComponentFamily.INTEL
        )
        .addRGB()
        .addExtraRAM()
        .build();
        computer1.evaluateCost();

        System.out.println("-------------------------------------------");

        Computer computer2 = ComputerFactory.create(
            ComputerType.GAMING_PC,
            ComponentFamily.INTEL
        )
        .addRGB()
        .addExtraRAM()
        .build();
        computer2.evaluateCost();

        System.out.println("-------------------------------------------");
        
        Computer computer3 = ComputerFactory.create(
            ComputerType.GAMING_PC,
            ComponentFamily.INTEL
        )
        .addRGB()
        .addExtraRAM()
        .build();
        computer3.evaluateCost();

        System.out.println("-------------------------------------------");

        computer2.evaluateSale();
    }
}
