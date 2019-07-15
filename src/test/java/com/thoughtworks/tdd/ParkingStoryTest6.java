package com.thoughtworks.tdd;

import org.junit.jupiter.api.Test;

import java.util.concurrent.CancellationException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParkingStoryTest6 {
    @Test
    public void should_park_car_and_pick_car_when_the_parkingManage_let_the_park_boy_in_his_manageList() throws NullTickedProvidedException, UnrecognizedParkingTicketException, ParkingLotIsFullException {
        //given
        ParkingLot parkingLot = new ParkingLot(10);
        ParkingManage parkingManage = new ParkingManage(parkingLot);
        Parker parkingBoy = new ParkingBoy(parkingLot);
        parkingManage.putInManageList((ParkingBoy) parkingBoy);

        Car car1 = new Car();

        //when
        TicketLog ticketLog = parkingManage.parkCar(car1);
        //then
        assertEquals(parkingManage.pickCar(ticketLog),car1);
    }

    @Test
    public void should_park_car_and_pick_car_By_parkingManage() throws ParkingLotIsFullException, UnrecognizedParkingTicketException, NullTickedProvidedException {
        //given
        ParkingLot parkingLot = new ParkingLot(10);
        ParkingManage parkingManage = new ParkingManage(parkingLot);
        Car car1 = new Car();
        //when
        TicketLog ticketLog = parkingManage.parkCar(car1);

        //then
        assertEquals(parkingManage.pickCar(ticketLog),car1);
    }
}
