package AbstractFactoryDesignPattern.ComputerManufacturingCompany.families.intel;

import AbstractFactoryDesignPattern.ComputerManufacturingCompany.enums.ComponentFamily;
import AbstractFactoryDesignPattern.ComputerManufacturingCompany.families.CPU;

public class IntelCPU implements CPU {
    @Override
    public void create() {
        System.out.println(ComponentFamily.INTEL + " CPU");
    }
}
