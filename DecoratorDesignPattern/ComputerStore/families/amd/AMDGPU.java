package DecoratorDesignPattern.ComputerStore.families.amd;

import DecoratorDesignPattern.ComputerStore.families.GPU;

public class AMDGPU implements GPU {
    @Override
    public void create() {
        System.out.println("AMD GPU");
    }
}
