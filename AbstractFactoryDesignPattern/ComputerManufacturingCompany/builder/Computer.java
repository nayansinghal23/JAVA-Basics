package AbstractFactoryDesignPattern.ComputerManufacturingCompany.builder;

import java.util.List;

import AbstractFactoryDesignPattern.ComputerManufacturingCompany.enums.Additionals;
import AbstractFactoryDesignPattern.ComputerManufacturingCompany.enums.ComponentFamily;
import AbstractFactoryDesignPattern.ComputerManufacturingCompany.enums.ComputerType;
import AbstractFactoryDesignPattern.ComputerManufacturingCompany.registry.ComputerRegistry;

public class Computer {
    private final ComputerType computerType;
    private final ComponentFamily componentFamily;
    private final List<Additionals> list;
    private final ComputerRegistry computerRegistry;
    
    public Computer(ComputerBuilder builder) {
        computerType = builder.getComputerType();
        componentFamily = builder.getComponentFamily();
        computerRegistry = ComputerRegistry.getInstance();
        computerRegistry.setSales(componentFamily);
        list = builder.getList();
    }

    public void evaluateCost() {
        int total = 0;
        for(Additionals additional: list) {
            int price = computerRegistry.getAdditinalsCost(additional);
            System.out.println(additional + " = " + price);
            total += price;
        }
        System.out.println("Total cost = " + total);
    }

    public void evaluateSale() {
        int total = 0;
        for(ComponentFamily family : computerRegistry.getComponentFamilies()) {
            int sale = computerRegistry.getSales(family);
            System.out.println(family + " = " + sale);
            total += sale;
        }
        System.out.println("Total = " + total);
    }
}
