package com.lld.lowleveldesign.parkinglot.vehicle;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Vehicle {
    private String vehicleNumber;
    VehicleType vehicleType;
    
    public Vehicle(String vehicleNumber, VehicleType vehicleType) {
        this.vehicleNumber = vehicleNumber;
        this.vehicleType = vehicleType;
    }
    
    public String getVehicleNumber() {
        return this.vehicleNumber;
    }
    
    public abstract VehicleType getVehicleType(Vehicle vehicle);
    
}
