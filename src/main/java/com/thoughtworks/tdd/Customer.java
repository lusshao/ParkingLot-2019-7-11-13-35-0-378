package com.thoughtworks.tdd;

public class Customer {

    private Car car;
    private TicketLog ticketLog;

    public Customer(Car car) {
        this.car = car;
    }

    public void parkCar(ParkingBoy parkingBoy){
        this.ticketLog = parkingBoy.parkCar(car);
        this.car = null;
    }

    public void pickCar(ParkingBoy parkingBoy){
        this.car = parkingBoy.pickCar(ticketLog);
        this.ticketLog = null;
    }

    public Car getCar() {
        return car;
    }

    public void setTicketLog(TicketLog ticketLog) {
        this.ticketLog = ticketLog;
    }
}
