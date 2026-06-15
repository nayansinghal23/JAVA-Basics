package DecoratorDesignPattern.ComputerStore.factories;

import DecoratorDesignPattern.ComputerStore.families.CPU;
import DecoratorDesignPattern.ComputerStore.families.GPU;
import DecoratorDesignPattern.ComputerStore.families.MotherBoard;
import DecoratorDesignPattern.ComputerStore.families.intel.IntelCPU;
import DecoratorDesignPattern.ComputerStore.families.intel.IntelGPU;
import DecoratorDesignPattern.ComputerStore.families.intel.IntelMotherBoard;

public class IntelFactory implements Factory {
    @Override
    public void createCPU() {
        CPU cpu = new IntelCPU();
        cpu.create();
    }

    @Override
    public void createGPU() {
        GPU gpu = new IntelGPU();
        gpu.create();
    }

    @Override
    public void createMotherBoard() {
        MotherBoard motherBoard = new IntelMotherBoard();
        motherBoard.create();
    }
}
