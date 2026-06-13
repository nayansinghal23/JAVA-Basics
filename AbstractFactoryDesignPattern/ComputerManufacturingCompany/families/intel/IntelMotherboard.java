package AbstractFactoryDesignPattern.ComputerManufacturingCompany.families.intel;

import AbstractFactoryDesignPattern.ComputerManufacturingCompany.enums.ComponentFamily;
import AbstractFactoryDesignPattern.ComputerManufacturingCompany.families.Motherboard;

public class IntelMotherboard implements Motherboard {
    @Override
    public void create() {
        System.out.println(ComponentFamily.INTEL + " Motherboard");
    }
}
