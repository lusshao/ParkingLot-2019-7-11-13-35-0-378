package com.thoughtworks.tdd;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParkingStoryTest2 {

    @Test
    public void should_return_Unrecognized_parking_ticket_when_pick_car_given_a_wrong_ticket(){
        //given
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        ParkingLot parkingLot = new ParkingLot(2);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        Car car1 = new Car();
        Car car2 = new Car();
        Customer customer1 = new Customer(car1);
        Customer customer2 = new Customer(car2);

        //when
        customer1.parkCar(parkingBoy);
        customer2.parkCar(parkingBoy);
        customer1.setTicketLog(new TicketLog());
        TicketLog ticketLog = customer2.getTicketLog();
        customer2.pickCar(parkingBoy);
        customer2.setTicketLog(ticketLog);

        //then
        customer1.pickCar(parkingBoy);
        customer2.pickCar(parkingBoy);
        assertEquals("Unrecognized parking ticket\nUnrecognized parking ticket\n", output.toString());
        System.setOut(System.out);

    }

    @Test
    public void should_return_Please_provide_your_parking_ticket_when_pick_car_given_ticked_is_null(){
        //given
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
        ParkingLot parkingLot = new ParkingLot(2);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        Car car1 = new Car();
        Customer customer1 = new Customer(car1);

        //when
        customer1.parkCar(parkingBoy);
        customer1.setTicketLog(null);
        customer1.pickCar(parkingBoy);

        //then
        assertEquals("Please provide your parking ticket\n", output.toString());
        System.setOut(System.out);
    }

    @Test
    public void should_return_Not_enough_position_when_ParkingLot_is_full(){
        //given
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
        ParkingLot parkingLot = new ParkingLot(1);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        Car car1 = new Car();
        Car car2 = new Car();
        Customer customer1 = new Customer(car1);
        Customer customer2 = new Customer(car2);

        //when
        customer1.parkCar(parkingBoy);
        customer2.parkCar(parkingBoy);

        //then
        assertEquals("Not enough position.\n", output.toString());
        System.setOut(System.out);
    }
}
