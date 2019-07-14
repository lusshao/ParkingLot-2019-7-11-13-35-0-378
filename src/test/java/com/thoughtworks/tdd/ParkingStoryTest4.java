package com.thoughtworks.tdd;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParkingStoryTest4 {

    @Test
    public void should_park_car_to_most_capacity_parkingLot_when_park_car_by_smartParkingBoy() throws NullTickedProvidedException, UnrecognizedParkingTicketException {
        //given
        ParkingLot parkingLot1 = new ParkingLot(10);
        ParkingLot parkingLot2 = new ParkingLot(20);
        ParkingLot parkingLot3 = new ParkingLot(5);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy();
        smartParkingBoy.getNewParkingLot(parkingLot1);
        smartParkingBoy.getNewParkingLot(parkingLot2);
        smartParkingBoy.getNewParkingLot(parkingLot3);
        Car car = new Car();
        Customer customer = new Customer(car);

        //when
        customer.parkCar(smartParkingBoy);

        //then
        assertEquals(parkingLot2.pickCar(customer.getTicketLog()),car);

    }
}
