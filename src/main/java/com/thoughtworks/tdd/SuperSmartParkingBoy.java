package com.thoughtworks.tdd;

public class SuperSmartParkingBoy extends ParkingBoy {
    public TicketLog parkCar(Car car) throws ParkingLotIsFullException {
        double parkingLotNowAvailable = 0;
        int shouldParkIndex = 0;
        for(int i=0;i<super.getParkingLots().size();i++) {
            if((double)super.getParkingLots().get(i).getNowAvailablePositionRate()>(double)parkingLotNowAvailable){
                parkingLotNowAvailable = super.getParkingLots().get(i).getNowAvailablePositionRate();
                shouldParkIndex = i;
            }
        }
        return super.getParkingLots().get(shouldParkIndex).parkCar(car);
    }
}
