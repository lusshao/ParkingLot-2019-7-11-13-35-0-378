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



    public void callBoysParkCar(ParkingBoy parkingBoys,Customer customer) throws ParkingLotIsFullException {
        customer.parkCar(parkingBoys);
    }

    public void callBoysPickCar(ParkingBoy parkingBoys,Customer customer) throws NullTickedProvidedException, UnrecognizedParkingTicketException {
        customer.pickCar(parkingBoys);
    }


    public void putInManageList(ParkingBoy parkingBoy) {
        parkingBoy.getNewParkingLot(parkingLot);
        parkingBoys.add(parkingBoy);
    }
}
