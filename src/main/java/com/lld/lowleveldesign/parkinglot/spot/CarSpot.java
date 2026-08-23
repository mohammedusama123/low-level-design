package com.lld.lowleveldesign.parkinglot.spot;

import com.lld.lowleveldesign.parkinglot.vehicle.Car;
import com.lld.lowleveldesign.parkinglot.vehicle.Vehicle;

public class CarSpot extends ParkingSpot{
    
    public CarSpot(int id) {
        super(id);
    }

    @Override
    public boolean canFit(Vehicle vehicle) {
        return vehicle instanceof Car;
    }
}
