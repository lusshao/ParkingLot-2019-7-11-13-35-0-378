package com.thoughtworks.tdd;

public class ParkingBoy {
    private ParkingLot parkingLot;


    public ParkingBoy(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public TicketLog parkCar(Car car) {
        return  parkingLot.parkCar(car);
    }

    public Car pickCar(TicketLog ticketLog) {
        return parkingLot.pickCar(ticketLog);
    }
}
