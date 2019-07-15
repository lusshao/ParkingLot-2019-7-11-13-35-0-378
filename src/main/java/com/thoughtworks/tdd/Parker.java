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

    public abstract TicketLog parkCar(Car car) throws ParkingLotIsFullException;

    public Car pickCar(TicketLog ticketLog) throws  NullTickedProvidedException, UnrecognizedParkingTicketException {
        for(int i =0;i<parkingLots.size();i++){
            if(parkingLots.get(i).hasTicketLog(ticketLog)){
                return parkingLots.get(i).pickCar(ticketLog);
            }
        }
        return parkingLots.get(0).pickCar(ticketLog);
    }

    public TicketLog parkCar(Car car, ParkingLot ticketLog) throws ParkingLotIsFullException {
        return ticketLog.parkCar(car);
    }

    public Car pickCar(TicketLog ticketLog, ParkingLot parkingLot) throws NullTickedProvidedException, UnrecognizedParkingTicketException {
        return parkingLot.pickCar(ticketLog);
    }

    public void getNewParkingLot(ParkingLot parkingLot) {
        parkingLots.add(parkingLot);
    }

    @Override
    public boolean iSFull() {
        for(int i=0;i<parkingLots.size();i++) {
            if (parkingLots.get(i).getNowCapasity() > 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isContainTicket(TicketLog ticketLog) {
        for(int i =0;i<parkingLots.size();i++){
            if(parkingLots.get(i).hasTicketLog(ticketLog)){
                return true;
            }
        }
        return false;
    }
}
