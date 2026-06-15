package DecoratorDesignPattern.ComputerStore.families.intel;

import DecoratorDesignPattern.ComputerStore.families.GPU;

public class IntelGPU implements GPU {
    @Override
    public void create() {
        System.out.println("Intel GPU");
    }
}
