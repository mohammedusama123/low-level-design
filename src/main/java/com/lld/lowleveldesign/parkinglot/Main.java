package com.lld.lowleveldesign.parkinglot;

import com.lld.lowleveldesign.parkinglot.pricingStrategy.HourlyPricingStrategy;
import com.lld.lowleveldesign.parkinglot.pricingStrategy.PricingStrategy;
import com.lld.lowleveldesign.parkinglot.pricingStrategy.WeekendPricingStrategy;
import com.lld.lowleveldesign.parkinglot.spot.BikeSpot;
import com.lld.lowleveldesign.parkinglot.spot.CarSpot;
import com.lld.lowleveldesign.parkinglot.spot.ParkingSpot;
import com.lld.lowleveldesign.parkinglot.vehicle.Bike;
import com.lld.lowleveldesign.parkinglot.vehicle.Vehicle;
import com.lld.lowleveldesign.parkinglot.vehicle.VehicleFactory;
import com.lld.lowleveldesign.parkinglot.vehicle.VehicleType;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        List<ParkingFloor> parkingFloors = new ArrayList<>();
        List<ParkingSpot> parkingSpots = new ArrayList<>();
        ParkingSpot parkingSpot = new BikeSpot(101);
        ParkingSpot carParkingSpot = new CarSpot(201);
        parkingSpots.add(parkingSpot);
        parkingSpots.add(carParkingSpot);
        parkingFloors.add(new ParkingFloor(1, parkingSpots));
        //PricingStrategy pricingStrategy = new HourlyPricingStrategy();
        PricingStrategy weekendPricingStrategy = new WeekendPricingStrategy();
        ParkingLot lot = new ParkingLot(parkingFloors, weekendPricingStrategy);
        VehicleFactory vehicleFactory = new VehicleFactory();
        Vehicle vehicle = vehicleFactory.create(VehicleType.CAR, "AP40DV9240");
        ParkingTicket parkingTicket = lot.findSpot(vehicle);
        System.out.println("ticket" + " parking spot id: " + parkingTicket.getParkingSpot().getId() + " ticket number: " + parkingTicket.getTicketId() + " entry time: " + parkingTicket.getEntryTime());
        Thread.sleep(3000);
        double fee = lot.vehicleExit(parkingTicket.getTicketId());
        System.out.println(fee);
    }
}
