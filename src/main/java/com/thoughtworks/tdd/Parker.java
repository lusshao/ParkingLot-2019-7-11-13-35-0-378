package com.thoughtworks.tdd;

import java.util.ArrayList;
import java.util.List;

public abstract class Parker implements CanParkCar {
    protected List<ParkingLot> parkingLots = new ArrayList<ParkingLot>();

    public Parker(ParkingLot parkingLot) {
        parkingLots.add(parkingLot);
    }

    public Parker() {
    }

    public abstract TicketLog parkCar(Car car);

    public Car pickCar(TicketLog ticketLog) {
        if(parkingLots.stream().filter(x->x.hasTicketLog(ticketLog)).findFirst().isPresent()){
            return parkingLots.stream().filter(x->x.hasTicketLog(ticketLog)).findFirst().get().pickCar(ticketLog);
        }
        return parkingLots.get(0).pickCar(ticketLog);
    }

    public void getNewParkingLot(ParkingLot parkingLot) {
        parkingLots.add(parkingLot);
    }

    @Override
    public boolean iSFull() {
        return parkingLots.stream().filter(x->x.getNowCapasity()>0).findFirst().isPresent();
    }

    @Override
    public boolean isContainTicket(TicketLog ticketLog) {
        return parkingLots.stream().filter(x->x.hasTicketLog(ticketLog)).findFirst().isPresent();
    }
}
