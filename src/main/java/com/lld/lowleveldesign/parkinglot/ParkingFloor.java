package com.lld.lowleveldesign.parkinglot;

import com.lld.lowleveldesign.parkinglot.spot.ParkingSpot;
import com.lld.lowleveldesign.parkinglot.vehicle.Vehicle;

import java.util.List;
import java.util.Optional;

public class ParkingFloor {
    
    private int floorNumber;
    List<ParkingSpot> parkingSpots;
    
    public ParkingFloor(int floorNumber, List<ParkingSpot> parkingSpots) {
        this.floorNumber = floorNumber;
        this.parkingSpots = parkingSpots;
    }
    
    public Optional<ParkingSpot> findSpot(Vehicle vehicle) {
        Optional<ParkingSpot> parkingSpotOptional = parkingSpots.stream()
                .filter(ParkingSpot::isAvailable)
                .filter(spot -> spot.canFit(vehicle))
                .findFirst();
        return parkingSpotOptional;
    }
    
    public int getFloorNumber() {
        return this.floorNumber;
    }
}
