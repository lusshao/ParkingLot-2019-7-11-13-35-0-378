package com.thoughtworks.tdd;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParkingStoryTest3 {
    @Test
    public void should_get_the_parkingLot2_ticket_when_parkingLot1_is_Full() throws NullTickedProvidedException, UnrecognizedParkingTicketException {

        ParkingLot parkingLot1 = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot(3);
        ParkingBoy parkingBoy = new ParkingBoy();
        parkingBoy.getNewParkingLot(parkingLot1);
        parkingBoy.getNewParkingLot(parkingLot2);
        Car car1 = new Car();
        Car car2 = new Car();

        parkingBoy.parkCar(car1);
        TicketLog ticketLog = parkingBoy.parkCar(car2);

        assertEquals(parkingLot2.pickCar(ticketLog),car2);
    }

}
