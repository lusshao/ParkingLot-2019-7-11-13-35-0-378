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

}
