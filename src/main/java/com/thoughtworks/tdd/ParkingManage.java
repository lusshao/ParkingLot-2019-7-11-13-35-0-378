package com.thoughtworks.tdd;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ParkingManage{

    private List<CanParkCar> canParkCarList = new ArrayList<CanParkCar>();

    public ParkingManage(ParkingLot parkingLot) {
        canParkCarList.add(parkingLot);
    }
    public TicketLog parkCar(Car car){
        if(canParkCarList.stream().filter(x-> !x.iSFull()).findFirst().isPresent()){
            return canParkCarList.stream().filter(x-> !x.iSFull()).findFirst().get().parkCar(car);
        }
        throw new ParkingLotIsFullException();
    }

    public Car pickCar(TicketLog ticketLog) throws NullTickedProvidedException, UnrecognizedParkingTicketException {
        if(ticketLog ==null){
            throw new NullTickedProvidedException();
        }
        if(canParkCarList.stream().filter(x->x.isContainTicket(ticketLog)).findFirst().isPresent()){
            return canParkCarList.stream().filter(x->x.isContainTicket(ticketLog)).findFirst().get().pickCar(ticketLog);
        }
        throw new UnrecognizedParkingTicketException();
    }

    public void putInManageList(ParkingBoy parkingBoy) {
        canParkCarList.add(parkingBoy);
    }
}
