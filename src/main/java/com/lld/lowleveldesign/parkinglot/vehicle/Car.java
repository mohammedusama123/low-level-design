package com.lld.lowleveldesign.parkinglot.vehicle;

public class Car extends Vehicle{
    
    public Car(String vehicleNumber) {
        super(vehicleNumber);
    }

    @Override
    public VehicleType getVehicleType(Vehicle vehicle) {
        return VehicleType.CAR;
    }
}
