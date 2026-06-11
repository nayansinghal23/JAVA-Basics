package FactoryDesignPattern.VehicleManufacturingSystem;

import java.util.List;

public class Vehicle {
    private final VehicleType vehicleType;
    private final List<Features> features;
    private final VehicleRegistry registry;
    
    public Vehicle(VehicleBuilder builder) {
        vehicleType = builder.getVehicleType();
        features = builder.getFeatures();
        registry = new VehicleRegistry();
    }

    public List<Features> getFeatures() {
        return this.features;
    }

    public void generateBill() {
        int base = registry.getVehicleBaseCost(vehicleType);
        System.out.println(vehicleType + " = " + base);
        for(Features feature : features) {
            int cost = registry.getFeatureCost(feature);
            base += cost;
            System.out.println(feature + " = " + cost);
        }
        System.out.println("Total = " + base);
    }
}
