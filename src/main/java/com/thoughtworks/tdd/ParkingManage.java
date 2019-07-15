package com.thoughtworks.tdd;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ParkingManage{

    private List<CanParkCar> canParkCarList = new ArrayList<CanParkCar>();

    public ParkingManage(ParkingLot parkingLot) {
        canParkCarList.add(parkingLot);
    }
    public TicketLog parkCar(Car car) throws ParkingLotIsFullException {
        for(int i=0;i<canParkCarList.size();i++){
            if(!canParkCarList.get(i).iSFull()){
                return canParkCarList.get(i).parkCar(car);
            }
        }
        throw new ParkingLotIsFullException();
    }

    public Car pickCar(TicketLog ticketLog) throws NullTickedProvidedException, UnrecognizedParkingTicketException {
        if(ticketLog ==null){
            throw new NullTickedProvidedException();
        }
        for(int i=0;i<canParkCarList.size();i++){
            if (canParkCarList.get(i).isContainTicket(ticketLog)){
                return canParkCarList.get(i).pickCar(ticketLog);
            }
        }
        throw new UnrecognizedParkingTicketException();
    }

    public void putInManageList(ParkingBoy parkingBoy) {
        canParkCarList.add(parkingBoy);
    }
}
