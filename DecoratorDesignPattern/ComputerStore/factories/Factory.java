package DecoratorDesignPattern.ComputerStore.factories;

public interface Factory {
    void createCPU();
    void createGPU();
    void createMotherBoard();
}
