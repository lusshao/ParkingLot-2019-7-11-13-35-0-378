package com.thoughtworks.tdd;

import java.util.ArrayList;
import java.util.List;

public class ParkingBoy extends Parker implements CanParkCar{

    public ParkingBoy(ParkingLot parkingLot) {
        parkingLots.add(parkingLot);
    }

    public ParkingBoy() {
    }

    public TicketLog parkCar(Car car) throws ParkingLotIsFullException {
        if(parkingLots.stream().filter(x-> !x.iSFull()).findFirst().isPresent()){
            System.out.println(parkingLots.stream().filter(x-> !x.iSFull()).findFirst().get().getNowCapasity());
            return parkingLots.stream().filter(x-> !x.iSFull()).findFirst().get().parkCar(car);
        }
        return parkingLots.get(0).parkCar(car);
    }
}
