package com.thoughtworks.tdd;

public class SmartParkingBoy extends ParkingBoy{

    public TicketLog parkCar(Car car) throws ParkingLotIsFullException {
        int parkingLotNowSize = 0;
        int shouldParkIndex = 0;
        for(int i=0;i<super.getParkingLots().size();i++) {
            if(super.getParkingLots().get(i).getNowCapasity()>parkingLotNowSize){
                parkingLotNowSize = super.getParkingLots().get(i).getNowCapasity();
                shouldParkIndex = i;
            }
        }
        return super.getParkingLots().get(shouldParkIndex).parkCar(car);
    }

}
