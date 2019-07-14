package com.thoughtworks.tdd;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParkingStoryTest3 {
    @Test
    public void should_get_the_parkingLot2_ticket_when_parkingLot1_is_Full() throws NullTickedProvidedException, UnrecognizedParkingTicketException {
        //given
        ParkingLot parkingLot1 = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot(3);
        ParkingBoy parkingBoy = new ParkingBoy();
        parkingBoy.getNewParkingLot(parkingLot1);
        parkingBoy.getNewParkingLot(parkingLot2);
        Car car1 = new Car();
        Car car2 = new Car();
        Customer customer1 = new Customer(car1);
        Customer customer2 = new Customer(car2);

        //when
        customer1.parkCar(parkingBoy);
        customer2.parkCar(parkingBoy);

        //then
        assertEquals(parkingLot2.pickCar(customer2.getTicketLog()),car2);
    }

}
