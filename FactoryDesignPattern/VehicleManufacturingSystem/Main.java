package FactoryDesignPattern.VehicleManufacturingSystem;

public class Main {
    public static void main(String[] args) {
        Vehicle vehicle = VehicleFactory.create(VehicleType.CAR).addSunroof().addGPS().build();
        vehicle.generateBill();
    }
}
