package com.thoughtworks.tdd;

public class SuperSmartParkingBoy extends Parker{
    public TicketLog parkCar(Car car) throws ParkingLotIsFullException {
        double parkingLotNowAvailable = 0;
        int shouldParkIndex = 0;
        for(int i=0;i<super.parkingLots.size();i++) {
            if((double)super.parkingLots.get(i).getNowAvailablePositionRate()>(double)parkingLotNowAvailable){
                parkingLotNowAvailable = super.parkingLots.get(i).getNowAvailablePositionRate();
                shouldParkIndex = i;
            }
        }
        return super.parkingLots.get(shouldParkIndex).parkCar(car);
    }
}
