package com.lld.lowleveldesign.parkinglot.pricingStrategy;

import com.lld.lowleveldesign.parkinglot.ParkingTicket;

import java.time.Duration;
import java.time.LocalDateTime;

public class HourlyPricingStrategy extends PricingStrategy{
    @Override
    public double calculateFees(ParkingTicket ticket) {
        LocalDateTime exitTime = LocalDateTime.now();
        double hours = Duration.between(ticket.getEntryTime(), exitTime).toHours();
        if(hours < 1) {
            hours = 1;
        }
        double fee = hours * 20.0;
        return fee;
    }
}
