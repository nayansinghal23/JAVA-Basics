package AbstractFactoryDesignPattern.ComputerManufacturingCompany.families.amd;

import AbstractFactoryDesignPattern.ComputerManufacturingCompany.enums.ComponentFamily;
import AbstractFactoryDesignPattern.ComputerManufacturingCompany.families.CPU;

public class AMDCPU implements CPU {
    @Override
    public void create() {
        System.out.println(ComponentFamily.AMD + " CPU");
    }
}
