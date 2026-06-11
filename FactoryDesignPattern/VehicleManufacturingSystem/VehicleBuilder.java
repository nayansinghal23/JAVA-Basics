package FactoryDesignPattern.VehicleManufacturingSystem;

import java.util.ArrayList;
import java.util.List;

public class VehicleBuilder {
    private final VehicleType vehicleType;
    private final List<Features> features;

    public VehicleBuilder(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
        features = new ArrayList<>();
    }

    public List<Features> getFeatures() {
        return this.features;
    }

    public VehicleType getVehicleType() {
        return this.vehicleType;
    }

    public VehicleBuilder addSunroof() {
        features.add(Features.SUNROOF);
        return this;
    }

    public VehicleBuilder addNavigation() {
        features.add(Features.NAVIGATION);
        return this;
    }

    public VehicleBuilder addGPS() {
        features.add(Features.GPS);
        return this;
    }

    public VehicleBuilder addExtraContainer() {
        features.add(Features.EXTRA_CONTAINER);
        return this;
    }

    public VehicleBuilder addAutomatic() {
        features.add(Features.AUTOMATIC);
        return this;
    }

    public VehicleBuilder addABS() {
        features.add(Features.ABS);
        return this;
    }

    public Vehicle build() {
        return new Vehicle(this);
    }
}
