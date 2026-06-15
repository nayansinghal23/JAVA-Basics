package DecoratorDesignPattern.ComputerStore.families.amd;

import DecoratorDesignPattern.ComputerStore.families.MotherBoard;

public class AMDMotherBoard implements MotherBoard {
    @Override
    public void create() {
        System.out.println("AMD Motherboard");
    }
}
