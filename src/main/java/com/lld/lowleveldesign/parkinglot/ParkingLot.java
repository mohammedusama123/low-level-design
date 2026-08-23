package com.lld.lowleveldesign.parkinglot;

import com.lld.lowleveldesign.parkinglot.pricingStrategy.PricingStrategy;
import com.lld.lowleveldesign.parkinglot.spot.ParkingSpot;
import com.lld.lowleveldesign.parkinglot.vehicle.Vehicle;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

public class ParkingLot {
    
    private List<ParkingFloor> floorList;
    private Map<String, ParkingTicket> activeTickets = new HashMap<>();
    PricingStrategy pricingStrategy;
    
    public ParkingLot(List<ParkingFloor> floorList, PricingStrategy pricingStrategy) {
        this.floorList = floorList;
        this.pricingStrategy = pricingStrategy;
    }
    
    public ParkingTicket findSpot(Vehicle vehicle) {
        for(ParkingFloor floor: floorList) {
            Optional<ParkingSpot> spot = floor.findSpot(vehicle);
            if(spot.isPresent()) {
                ParkingSpot parkingSpot = spot.get();
                parkingSpot.park(vehicle);
                
                ParkingTicket parkingTicket = new ParkingTicket(UUID.randomUUID().toString(), vehicle, LocalDateTime.now(), parkingSpot);
                activeTickets.put(parkingTicket.getTicketId(), parkingTicket);
                return parkingTicket;
            }
        }
        throw new IllegalStateException("Parking spot is not available");
    }
    
    public double vehicleExit(String ticketNumber) {
        ParkingTicket parkingTicket = activeTickets.get(ticketNumber);
        if(parkingTicket == null) {
            throw new IllegalArgumentException("invalid ticket");
        }
        
        double fee = pricingStrategy.calculateFees(parkingTicket);
        
        parkingTicket.getParkingSpot().removeVehicle();
        activeTickets.remove(ticketNumber);
        return fee;
    }
}
