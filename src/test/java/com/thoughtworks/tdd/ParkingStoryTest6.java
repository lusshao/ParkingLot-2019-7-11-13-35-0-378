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
        CanParkCar parkingBoy = new ParkingBoy();
        CanParkCar parkingBoy2 = new SmartParkingBoy();
        CanParkCar parkingBoy3 = new SuperSmartParkingBoy();
        parkingManage.putInManageList((ParkingBoy) parkingBoy);
        parkingManage.putInManageList((ParkingBoy) parkingBoy2);
        parkingManage.putInManageList((ParkingBoy) parkingBoy3);
        Car car1 = new Car();
        Customer customer1 = new Customer(car1);

        //when
        parkingManage.callBoysParkCar((ParkingBoy) parkingBoy,customer1);
        parkingManage.callBoysPickCar((ParkingBoy) parkingBoy2,customer1);
        //then
        assertEquals(customer1.getCar(),car1);
    }

    @Test
    public void should_park_car_and_pick_car_By_parkingManage(){
        //given
        ParkingLot parkingLot = new ParkingLot(10);
        ParkingManage parkingManage = new ParkingManage(parkingLot);
        Car car1 = new Car();
        Customer customer1 = new Customer(car1);

        //when
        customer1.parkCar(parkingManage);
        customer1.parkCar(parkingManage);
        //then
        assertEquals(customer1.getCar(),car1);
    }
}
