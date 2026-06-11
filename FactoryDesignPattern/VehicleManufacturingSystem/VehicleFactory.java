package FactoryDesignPattern.VehicleManufacturingSystem;

public class VehicleFactory {
    public static VehicleBuilder create(VehicleType type) {
        return new VehicleBuilder(type);
    }
}
