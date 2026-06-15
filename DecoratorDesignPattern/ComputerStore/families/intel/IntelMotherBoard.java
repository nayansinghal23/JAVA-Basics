package DecoratorDesignPattern.ComputerStore.families.intel;

import DecoratorDesignPattern.ComputerStore.families.MotherBoard;

public class IntelMotherBoard implements MotherBoard {
    @Override
    public void create() {
        System.out.println("Intel MotherBoard");
    }
}
