package com.lld.lowleveldesign.parkinglot.vehicle;

public class Bike extends Vehicle{
    
    public Bike(String vehicleNumber) {
        super(vehicleNumber);
    }

    @Override
    public VehicleType getVehicleType(Vehicle vehicle) {
        return VehicleType.BIKE;
    }
}
