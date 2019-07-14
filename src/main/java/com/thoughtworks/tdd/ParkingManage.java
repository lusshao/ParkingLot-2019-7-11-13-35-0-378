package com.thoughtworks.tdd;

import java.util.ArrayList;
import java.util.List;

public class ParkingManage implements CanParkCar {

    private ParkingLot parkingLot;
    private List<ParkingBoy> parkingBoys = new ArrayList<ParkingBoy>();

    public ParkingManage(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    @Override
    public TicketLog parkCar(Car car) throws ParkingLotIsFullException {
        return parkingLot.parkCar(car);
    }

    @Override
    public Car pickCar(TicketLog ticketLog) throws NullTickedProvidedException, UnrecognizedParkingTicketException {
        return parkingLot.pickCar(ticketLog);
    }



    public TicketLog callBoysParkCar(int parkingBoysIndex,Car car) throws ParkingLotIsFullException {
        return parkingBoys.get(parkingBoysIndex).parkCar(car,parkingLot);
    }

    public Car callBoysPickCar(int parkingBoysIndex,TicketLog ticketLog) throws NullTickedProvidedException, UnrecognizedParkingTicketException {
        return parkingBoys.get(parkingBoysIndex).pickCar(ticketLog,parkingLot);
    }


    public void putInManageList(ParkingBoy parkingBoy) {
        parkingBoys.add(parkingBoy);
    }
}
