package com.thoughtworks.tdd;

public class Customer {

    private Car car;
    private TicketLog ticketLog;

    public Customer(Car car) {
        this.car = car;
    }

    public void parkCar(CanParkCar parkingBoy){
        try {
            this.ticketLog = parkingBoy.parkCar(car);
        } catch (ParkingLotIsFullException e) {
            ticketLog = null;
            System.out.print("Not enough position.\n");
        }
        if(ticketLog!=null) {
            this.car = null;
        }
    }

    public void pickCar(ParkingBoy parkingBoy){
        try {
            this.car = parkingBoy.pickCar(ticketLog);
        } catch (UnrecognizedParkingTicketException e) {
            car = null;
            System.out.print("Unrecognized parking ticket\n");
        } catch (NullTickedProvidedException e) {
            car = null;
            System.out.print("Please provide your parking ticket\n");
        }
        this.ticketLog = null;
    }

    public Car getCar() {
        return car;
    }

    public void setTicketLog(TicketLog ticketLog) {
        this.ticketLog = ticketLog;
    }

    public TicketLog getTicketLog() {
        return ticketLog;
    }
}
