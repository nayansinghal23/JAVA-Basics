package AbstractFactoryDesignPattern.ComputerManufacturingCompany.factories;

import AbstractFactoryDesignPattern.ComputerManufacturingCompany.families.CPU;
import AbstractFactoryDesignPattern.ComputerManufacturingCompany.families.Motherboard;
import AbstractFactoryDesignPattern.ComputerManufacturingCompany.families.amd.AMDCPU;
import AbstractFactoryDesignPattern.ComputerManufacturingCompany.families.amd.AMDMotherboard;

public class AMDFactory implements Component {
    @Override
    public CPU createCPU() {
        return new AMDCPU();
    }

    @Override
    public Motherboard createMotherboard() {
        return new AMDMotherboard();
    }
}
