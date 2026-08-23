package com.lld.lowleveldesign.parkinglot.vehicle;

public class Car extends Vehicle{
    
    public Car(String vehicleNumber, VehicleType type) {
        super(vehicleNumber, type);
    }

    @Override
    public VehicleType getVehicleType(Vehicle vehicle) {
        return VehicleType.CAR;
    }
}
