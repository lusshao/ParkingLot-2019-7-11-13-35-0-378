package com.thoughtworks.tdd;

public class Customer {

    private Car car;
    private TicketLog ticketLog;

    public Customer(Car car) {
        this.car = car;
    }

    public void parkCar(ParkingBoy parkingBoy){
        parkingBoy.parkCar(car);
    }

    public void pickCar(ParkingBoy parkingBoy){
        parkingBoy.pickCar(ticketLog);
    }

    public Car getCar() {
        return car;
    }
}
