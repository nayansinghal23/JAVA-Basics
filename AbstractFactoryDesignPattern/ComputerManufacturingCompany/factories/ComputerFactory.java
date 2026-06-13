package AbstractFactoryDesignPattern.ComputerManufacturingCompany.factories;

import AbstractFactoryDesignPattern.ComputerManufacturingCompany.enums.ComputerType;
import AbstractFactoryDesignPattern.ComputerManufacturingCompany.families.CPU;
import AbstractFactoryDesignPattern.ComputerManufacturingCompany.families.Motherboard;
import AbstractFactoryDesignPattern.ComputerManufacturingCompany.builder.ComputerBuilder;
import AbstractFactoryDesignPattern.ComputerManufacturingCompany.enums.ComponentFamily;

public class ComputerFactory {
    public static ComputerBuilder create(ComputerType computerType, ComponentFamily componentFamily) {
        Component component = null;

        if(componentFamily == ComponentFamily.INTEL) component = new IntelFactory();
        else if(componentFamily == ComponentFamily.AMD) component = new AMDFactory();
        
        if(component == null) throw new IllegalArgumentException("Component family is not supported!!!");

        CPU cpu = component.createCPU();
        Motherboard motherboard = component.createMotherboard();

        cpu.create();
        motherboard.create();
        return new ComputerBuilder(computerType, componentFamily);
    }
}
