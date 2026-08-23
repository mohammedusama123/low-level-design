package com.lld.lowleveldesign.parkinglot.vehicle;

public class VehicleFactory {
    public Vehicle create(VehicleType type, String licenseNumber) {
        return switch (type) {
            case BIKE -> new Bike(licenseNumber, type);
            case CAR -> new Car(licenseNumber, type);
        };
    }
}
