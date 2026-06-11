package FactoryDesignPattern.VehicleManufacturingSystem;

import java.util.HashMap;
import java.util.Map;

public class VehicleRegistry {
    private final Map<Features, Integer> featureRegistry;
    private final Map<VehicleType, Integer> vehicleTypeRegistry;

    public VehicleRegistry() {
        featureRegistry = new HashMap<>();
        vehicleTypeRegistry = new HashMap<>();
        seedFeatureCost();
        seedVehicleBaseCost();
    }

    public Integer getFeatureCost(Features feature) {
        return featureRegistry.getOrDefault(feature, 0);
    }

    public Integer getVehicleBaseCost(VehicleType type) {
        return vehicleTypeRegistry.getOrDefault(type, 0);
    }

    private void seedFeatureCost() {
        featureRegistry.put(Features.ABS, 10000);
        featureRegistry.put(Features.NAVIGATION, 5000);
        featureRegistry.put(Features.EXTRA_CONTAINER, 200000);
        featureRegistry.put(Features.GPS, 15000);
        featureRegistry.put(Features.SUNROOF, 50000);
        featureRegistry.put(Features.AUTOMATIC, 100000);
    }

    private void seedVehicleBaseCost() {
        vehicleTypeRegistry.put(VehicleType.CAR, 1000000);
        vehicleTypeRegistry.put(VehicleType.BIKE, 150000);
        vehicleTypeRegistry.put(VehicleType.TRUCK, 2500000);
    }
}
