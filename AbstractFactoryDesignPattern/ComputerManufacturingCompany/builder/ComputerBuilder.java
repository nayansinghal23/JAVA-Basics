package AbstractFactoryDesignPattern.ComputerManufacturingCompany.builder;

import java.util.ArrayList;
import java.util.List;

import AbstractFactoryDesignPattern.ComputerManufacturingCompany.enums.Additionals;
import AbstractFactoryDesignPattern.ComputerManufacturingCompany.enums.ComponentFamily;
import AbstractFactoryDesignPattern.ComputerManufacturingCompany.enums.ComputerType;

public class ComputerBuilder {
    private final ComputerType computerType;
    private final ComponentFamily componentFamily;
    private final List<Additionals> list;

    public ComputerBuilder(ComputerType computerType, ComponentFamily componentFamily) {
        this.computerType = computerType;
        this.componentFamily = componentFamily;
        list = new ArrayList<>();
    }

    public ComputerType getComputerType() {
        return computerType;
    }

    public ComponentFamily getComponentFamily() {
        return componentFamily;
    }

    public List<Additionals> getList() {
        return list;
    }

    public ComputerBuilder addRGB() {
        list.add(Additionals.RGB_LIGHTING);
        return this;
    }
    
    public ComputerBuilder addExtraRAM() {
        list.add(Additionals.EXTRA_RAM);
        return this;
    }

    public ComputerBuilder addExtraSSD() {
        list.add(Additionals.EXTRA_SSD);
        return this;
    }

    public ComputerBuilder addLiquidCooling() {
        list.add(Additionals.LIQUID_COOLING);
        return this;
    }

    public Computer build() {
        return new Computer(this);
    }
}
