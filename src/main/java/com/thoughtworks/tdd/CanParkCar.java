package com.thoughtworks.tdd;

public interface CanParkCar {
    public TicketLog parkCar(Car car) throws ParkingLotIsFullException;
    public Car pickCar(TicketLog ticketLog) throws NullTickedProvidedException, UnrecognizedParkingTicketException;
}
