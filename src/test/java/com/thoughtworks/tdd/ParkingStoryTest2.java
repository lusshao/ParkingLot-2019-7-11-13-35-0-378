package com.thoughtworks.tdd;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ParkingStoryTest2 {

    @Test
    public void should_return_Unrecognized_parking_ticket_when_pick_car_given_a_wrong_ticket(){

        ParkingLot parkingLot = new ParkingLot(5);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        Car car1 = new Car();

        parkingBoy.parkCar(car1);

        assertThrows(UnrecognizedParkingTicketException.class,()->parkingBoy.pickCar(new TicketLog()));

    }

    @Test
    public void should_return_Please_provide_your_parking_ticket_when_pick_car_given_ticked_is_null(){
        ParkingLot parkingLot = new ParkingLot(5);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        Car car1 = new Car();

        parkingBoy.parkCar(car1);

        assertThrows(NullTickedProvidedException.class,()->parkingBoy.pickCar(null));
    }

    @Test
    public void should_return_Not_enough_position_when_ParkingLot_is_full(){
        ParkingLot parkingLot = new ParkingLot(1);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        Car car1 = new Car();
        Car car2 = new Car();

        parkingBoy.parkCar(car1);

        assertThrows(ParkingLotIsFullException.class,()->parkingBoy.parkCar(car2));
    }
}
