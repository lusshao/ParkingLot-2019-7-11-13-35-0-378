package com.thoughtworks.tdd;

import java.util.ArrayList;
import java.util.List;

public class ParkingBoy {
    private List<ParkingLot> parkingLots = new ArrayList<ParkingLot>();


    public ParkingBoy(ParkingLot parkingLot) {
        parkingLots.add(parkingLot);
    }

    public ParkingBoy() {
    }

    public TicketLog parkCar(Car car) throws ParkingLotIsFullException {
        for(int i=0;i<parkingLots.size();i++) {
            if (parkingLots.get(i).getNowCapasity() > 0) {
                return parkingLots.get(i).parkCar(car);
            }
        }
        return parkingLots.get(0).parkCar(car);
    }

    public Car pickCar(TicketLog ticketLog) throws UnrecognizedParkingTicketException, NullTickedProvidedException {
        for(int i =0;i<parkingLots.size();i++){
            if(parkingLots.get(i).hasTicketLog(ticketLog)){
                return parkingLots.get(i).pickCar(ticketLog);
            }
        }
        return parkingLots.get(0).pickCar(ticketLog);
    }

    public void getNewParkingLot(ParkingLot parkingLot) {
        parkingLots.add(parkingLot);
    }
}
