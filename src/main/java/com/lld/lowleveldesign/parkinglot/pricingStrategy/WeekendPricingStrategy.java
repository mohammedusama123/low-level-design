package com.lld.lowleveldesign.parkinglot.pricingStrategy;

import com.lld.lowleveldesign.parkinglot.ParkingTicket;
import com.lld.lowleveldesign.parkinglot.vehicle.VehicleType;

import java.time.Duration;
import java.time.LocalDateTime;

public class WeekendPricingStrategy extends PricingStrategy{

    @Override
    public double calculateFees(ParkingTicket ticket) {
        LocalDateTime exitTime = LocalDateTime.now();
        double hours = Duration.between(ticket.getEntryTime(), exitTime).toHours();
        if(hours < 1) {
            hours = 1; 
        }
        double fee;
        if(ticket.getVehicle().getVehicleType().equals(VehicleType.BIKE)) {
            fee = hours * 40.0;
        }
        else {
            fee = hours * 80.0;
        }
        return fee;
    }
}
