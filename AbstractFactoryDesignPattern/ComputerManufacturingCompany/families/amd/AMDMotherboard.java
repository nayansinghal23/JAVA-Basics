package AbstractFactoryDesignPattern.ComputerManufacturingCompany.families.amd;

import AbstractFactoryDesignPattern.ComputerManufacturingCompany.enums.ComponentFamily;
import AbstractFactoryDesignPattern.ComputerManufacturingCompany.families.Motherboard;

public class AMDMotherboard implements Motherboard {
    @Override
    public void create() {
        System.out.println(ComponentFamily.AMD + " Motherboard");
    }
}
