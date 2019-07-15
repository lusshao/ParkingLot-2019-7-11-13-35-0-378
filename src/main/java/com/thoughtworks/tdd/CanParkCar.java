package com.thoughtworks.tdd;

public interface CanParkCar {
    public TicketLog parkCar(Car car);
    public Car pickCar(TicketLog ticketLog);

    boolean iSFull();

    boolean isContainTicket(TicketLog ticketLog);
}
