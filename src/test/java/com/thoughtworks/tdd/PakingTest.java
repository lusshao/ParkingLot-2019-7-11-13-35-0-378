package com.thoughtworks.tdd;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PakingTest {
    @Test
    public void should_park_car_and_pick_car(){
        //given
        ParkingLot parkingLot = new ParkingLot(1);
        Car car = new Car();
        //when
        TicketLog ticketLog = parkingLot.parkCar(car);
        Car car2 = parkingLot.pickCar(ticketLog);
        //then
        assertEquals(car,car2);
    }

    @Test
    public void should_return_null_when_PakingLot_is_full(){
        //given
        ParkingLot parkingLot = new ParkingLot(1);
        Car car = new Car();
        Car car2 = new Car();
        //when
        TicketLog ticketLog1 = parkingLot.parkCar(car);
        TicketLog ticketLog2 = parkingLot.parkCar(car2);
        //then
        assertEquals(ticketLog2,null);
    }

}
