package com.thoughtworks.tdd;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class ParkingStoryTest1 {

    @Test
    public void should_park_car_and_pick_car_by_parking_boy(){
        ParkingLot parkingLot = new ParkingLot(1);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        Car car = new Car();

        TicketLog ticketLog = parkingBoy.parkCar(car);

        assertEquals(parkingBoy.pickCar(ticketLog),car);

    }

    @Test
    public void should_return_two_right_car_when_pick_car_given_two_right_ticket(){
        ParkingLot parkingLot = new ParkingLot(5);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        Car car1 = new Car();
        Car car2 = new Car();

        TicketLog ticketLog1 = parkingBoy.parkCar(car1);
        TicketLog ticketLog2 = parkingBoy.parkCar(car2);

        assertEquals(parkingBoy.pickCar(ticketLog1),car1);
        assertEquals(parkingBoy.pickCar(ticketLog2),car2);
    }

    @Test
    public void should_return_null_when_pick_car_given_wrong_or_null_ticket(){
        ParkingLot parkingLot = new ParkingLot(5);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        Car car1 = new Car();
        Car car2 = new Car();
        parkingBoy.parkCar(car1);
        assertThrows(UnrecognizedParkingTicketException.class,()->parkingBoy.pickCar(new TicketLog()));
    }

    @Test
    public void should_return_null_when_pick_car_given_a_ticket_already_been_used(){
        ParkingLot parkingLot = new ParkingLot(5);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        Car car1 = new Car();
        TicketLog ticketLog = parkingBoy.parkCar(car1);
        parkingBoy.pickCar(ticketLog);

        assertThrows(UnrecognizedParkingTicketException.class,()->parkingBoy.pickCar(ticketLog));
    }

    @Test
    public void should_return_null_when_park_car_given_parkingLot_is_full(){
        ParkingLot parkingLot = new ParkingLot(1);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        Car car1 = new Car();
        Car car2 = new Car();

        parkingBoy.parkCar(car1);

        assertThrows(ParkingLotIsFullException.class,()->parkingBoy.parkCar(car2));

    }
}
