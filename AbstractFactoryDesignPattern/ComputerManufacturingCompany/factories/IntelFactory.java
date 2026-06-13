package AbstractFactoryDesignPattern.ComputerManufacturingCompany.factories;

import AbstractFactoryDesignPattern.ComputerManufacturingCompany.families.CPU;
import AbstractFactoryDesignPattern.ComputerManufacturingCompany.families.Motherboard;
import AbstractFactoryDesignPattern.ComputerManufacturingCompany.families.intel.IntelCPU;
import AbstractFactoryDesignPattern.ComputerManufacturingCompany.families.intel.IntelMotherboard;

public class IntelFactory implements Component {
    @Override
    public CPU createCPU() {
        return new IntelCPU();
    }

    @Override
    public Motherboard createMotherboard() {
        return new IntelMotherboard();
    }
    
}
