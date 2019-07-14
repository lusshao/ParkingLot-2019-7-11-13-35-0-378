package com.thoughtworks.tdd;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PakingTest {
    @Test
    public void should_park_car_and_pick_car() {
        //given
        ParkingLot parkingLot = new ParkingLot(1);
        Car car = new Car();
        //when
        TicketLog ticketLog = parkingLot.parkCar(car);
        Car car2 = parkingLot.pickCar(ticketLog);
        //then
        assertEquals(car, car2);
    }

    @Test
    public void should_return_null_when_PakingLot_is_full() {
        //given
        ParkingLot parkingLot = new ParkingLot(1);
        Car car = new Car();
        Car car2 = new Car();
        //when
        TicketLog ticketLog1 = parkingLot.parkCar(car);
        TicketLog ticketLog2 = parkingLot.parkCar(car2);
        //then
        assertEquals(ticketLog2, null);
    }

    @Test
    public void should_return_null_when_pick_car_twice_by_one_ticket() {
        //given
        ParkingLot parkingLot = new ParkingLot(1);
        Car car = new Car();
        //when
        TicketLog ticketLog = parkingLot.parkCar(car);
        Car car2 = parkingLot.pickCar(ticketLog);
        Car car3 = parkingLot.pickCar(ticketLog);
        //then
        assertEquals(car3, null);
    }

    @Test
    public void should_return_two_different_car_when_pick_car_given_two_different_ticket() {
        //given
        ParkingLot parkingLot = new ParkingLot(2);
        Car car1 = new Car();
        Car car2 = new Car();
        //when
        TicketLog ticketLog1 = parkingLot.parkCar(car1);
        TicketLog ticketLog2 = parkingLot.parkCar(car2);
        Car car3 = parkingLot.pickCar(ticketLog1);
        Car car4 = parkingLot.pickCar(ticketLog2);
        //then
        assertEquals(car1,car3);
        assertEquals(car2,car4);
    }

}
