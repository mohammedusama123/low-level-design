package com.lld.lowleveldesign.parkinglot.spot;

import com.lld.lowleveldesign.parkinglot.vehicle.Bike;
import com.lld.lowleveldesign.parkinglot.vehicle.Vehicle;

public class BikeSpot extends ParkingSpot{
    
    public BikeSpot(int id) {
        super(id);
    }

    @Override
    public boolean canFit(Vehicle vehicle) {
        return vehicle instanceof Bike;
    }
}
