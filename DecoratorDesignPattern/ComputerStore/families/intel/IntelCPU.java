package DecoratorDesignPattern.ComputerStore.families.intel;

import DecoratorDesignPattern.ComputerStore.families.CPU;

public class IntelCPU implements CPU {
    @Override
    public void create() {
        System.out.println("Intel CPU");
    }
}
