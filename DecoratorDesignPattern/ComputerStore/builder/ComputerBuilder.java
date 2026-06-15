package DecoratorDesignPattern.ComputerStore.builder;

import java.util.ArrayList;
import java.util.List;

import DecoratorDesignPattern.ComputerStore.enums.Additionals;
import DecoratorDesignPattern.ComputerStore.enums.ComputerType;
import DecoratorDesignPattern.ComputerStore.enums.FamilyType;

public class ComputerBuilder {
    private final ComputerType computerType;
    private final FamilyType familyType;
    private final List<Additionals> additionals;

    public ComputerBuilder(ComputerType computerType, FamilyType familyType) {
        this.computerType = computerType;
        this.familyType = familyType;
        this.additionals = new ArrayList<>();
    }

    public ComputerType getComputerType() {
        return computerType;
    }

    public FamilyType getFamilyType() {
        return familyType;
    }

    public List<Additionals> getAdditionals() {
        return additionals;
    }

    public ComputerBuilder addExtraRam() {
        additionals.add(Additionals.EXTRA_RAM);
        return this;
    }

    public ComputerBuilder addExtraSSD() {
        additionals.add(Additionals.EXTRA_SSD);
        return this;
    }

    public ComputerBuilder addLiquidCooling() {
        additionals.add(Additionals.LIQUID_COOLING);
        return this;
    }

    public ComputerBuilder addRGBLighting() {
        additionals.add(Additionals.RGC_LIGHTING);
        return this;
    }

    public Computer build() {
        return new Computer(this);
    }
}
