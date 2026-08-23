package com.lld.lowleveldesign.parkinglot.spot;

import com.lld.lowleveldesign.parkinglot.vehicle.Vehicle;

public abstract class ParkingSpot {
    private final int id;
    private Vehicle vehicle;

    public ParkingSpot(int id) {
        this.id = id;
    }
    
    public boolean isAvailable() {
        return vehicle == null;
    }
    
    public void park(Vehicle vehicle) {
        if(!isAvailable()) {
            throw new IllegalStateException("Parking spot is already occupied");
        }
        this.vehicle = vehicle;
    }
    
    public void removeVehicle() {
        this.vehicle = null;
    }

    public int getId() {
        return id;
    }
    
    public abstract boolean canFit(Vehicle vehicle);
    
}
