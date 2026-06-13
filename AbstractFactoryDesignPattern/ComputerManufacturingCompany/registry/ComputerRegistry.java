package AbstractFactoryDesignPattern.ComputerManufacturingCompany.registry;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import AbstractFactoryDesignPattern.ComputerManufacturingCompany.enums.Additionals;
import AbstractFactoryDesignPattern.ComputerManufacturingCompany.enums.ComponentFamily;

public class ComputerRegistry {
    private final Map<Additionals, Integer> additionalsRegistry;
    private final Map<ComponentFamily, Integer> salesRegistry;
    private final List<ComponentFamily> list;
    private static ComputerRegistry instance; 

    private ComputerRegistry() {
        System.out.println("Computer registry initialized");
        additionalsRegistry = new HashMap<>();
        salesRegistry = new HashMap<>();
        list = new ArrayList<>();
        seedAdditionalRegistry();
        seedComponentFamilyList();
    }

    public static ComputerRegistry getInstance() {
        if(instance == null) instance = new ComputerRegistry();
        return instance;
    }

    private void seedAdditionalRegistry() {
        additionalsRegistry.put(Additionals.RGB_LIGHTING, 3000);
        additionalsRegistry.put(Additionals.LIQUID_COOLING, 8000);
        additionalsRegistry.put(Additionals.EXTRA_SSD, 5000);
        additionalsRegistry.put(Additionals.EXTRA_RAM, 4000);
    }

    private void seedComponentFamilyList() {
        list.add(ComponentFamily.AMD);
        list.add(ComponentFamily.INTEL);
    }

    public int getAdditinalsCost(Additionals additionals) {
        return additionalsRegistry.getOrDefault(additionals, 0);
    }

    public void setSales(ComponentFamily family) {
        salesRegistry.put(family, getSales(family) + 1);
    }

    public int getSales(ComponentFamily family) {
        return salesRegistry.getOrDefault(family, 0);
    }

    public List<ComponentFamily> getComponentFamilies() {
        return list;
    }
}
