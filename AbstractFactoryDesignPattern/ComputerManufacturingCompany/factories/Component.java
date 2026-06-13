package AbstractFactoryDesignPattern.ComputerManufacturingCompany.factories;

import AbstractFactoryDesignPattern.ComputerManufacturingCompany.families.CPU;
import AbstractFactoryDesignPattern.ComputerManufacturingCompany.families.Motherboard;

public interface Component {
    CPU createCPU();
    Motherboard createMotherboard();
}
