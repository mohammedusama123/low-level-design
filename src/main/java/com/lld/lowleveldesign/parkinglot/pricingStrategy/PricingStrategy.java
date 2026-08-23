package com.lld.lowleveldesign.parkinglot.pricingStrategy;

import com.lld.lowleveldesign.parkinglot.ParkingTicket;

public abstract class PricingStrategy {
    
    public abstract double calculateFees(ParkingTicket ticket);
}
