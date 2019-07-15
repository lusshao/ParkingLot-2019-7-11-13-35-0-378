package com.thoughtworks.tdd;

public class SmartParkingBoy extends Parker{

    public TicketLog parkCar(Car car) throws ParkingLotIsFullException {
        int parkingLotNowSize = 0;
        int shouldParkIndex = 0;
        for(int i=0;i<parkingLots.size();i++) {
            if(parkingLots.get(i).getNowCapasity()>parkingLotNowSize){
                parkingLotNowSize = super.parkingLots.get(i).getNowCapasity();
                shouldParkIndex = i;
            }
        }
        return super.parkingLots.get(shouldParkIndex).parkCar(car);
    }

}
