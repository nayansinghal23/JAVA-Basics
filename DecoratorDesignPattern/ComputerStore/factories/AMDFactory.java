package DecoratorDesignPattern.ComputerStore.factories;

import DecoratorDesignPattern.ComputerStore.families.CPU;
import DecoratorDesignPattern.ComputerStore.families.GPU;
import DecoratorDesignPattern.ComputerStore.families.MotherBoard;
import DecoratorDesignPattern.ComputerStore.families.amd.AMDCPU;
import DecoratorDesignPattern.ComputerStore.families.amd.AMDGPU;
import DecoratorDesignPattern.ComputerStore.families.amd.AMDMotherBoard;

public class AMDFactory implements Factory {
    @Override
    public void createCPU() {
        CPU cpu = new AMDCPU();
        cpu.create();
    }

    @Override
    public void createGPU() {
        GPU gpu = new AMDGPU();
        gpu.create();
    }

    @Override
    public void createMotherBoard() {
        MotherBoard motherBoard = new AMDMotherBoard();
        motherBoard.create();
    }
}
