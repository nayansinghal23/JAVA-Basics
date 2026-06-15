package DecoratorDesignPattern.ComputerStore.families.amd;

import DecoratorDesignPattern.ComputerStore.families.CPU;

public class AMDCPU implements CPU {
    @Override
    public void create() {
        System.out.println("AMD CPU");
    }
}
