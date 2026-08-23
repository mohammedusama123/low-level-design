package com.lld.lowleveldesign.parkinglot.vehicle;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Vehicle {
    private String vehicleNumber;
    VehicleType vehicleType;
    
    public Vehicle(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }
    
    public String getVehicleNumber() {
        return this.vehicleNumber;
    }
    
    public abstract VehicleType getVehicleType(Vehicle vehicle);
    
}
