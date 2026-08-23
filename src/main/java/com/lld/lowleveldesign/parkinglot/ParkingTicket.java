package com.lld.lowleveldesign.parkinglot;

import com.lld.lowleveldesign.parkinglot.spot.ParkingSpot;
import com.lld.lowleveldesign.parkinglot.vehicle.Vehicle;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Setter
public class ParkingTicket {
    
    private String ticketId;
    private Vehicle vehicle;
    private LocalDateTime entryTime;
    private ParkingSpot parkingSpot;
}
