package com.thoughtworks.tdd;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ParkingStoryTest1 {

    @Test
    public void should_park_car_and_pick_car_by_parking_boy(){
        ParkingLot parkingLot = new ParkingLot(1);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        Car car = new Car();
        Customer customer = new Customer(car);
        customer.parkCar(parkingBoy);
        customer.pickCar(parkingBoy);
        assertEquals(customer.getCar(),car);

    }

    @Test
    public void should_return_two_right_car_when_pick_car_given_two_right_ticket(){
        ParkingLot parkingLot = new ParkingLot(5);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        Car car1 = new Car();
        Car car2 = new Car();
        Customer customer1 = new Customer(car1);
        Customer customer2 = new Customer(car2);
        customer1.parkCar(parkingBoy);
        customer2.parkCar(parkingBoy);
        customer1.pickCar(parkingBoy);
        customer2.pickCar(parkingBoy);
        assertEquals(customer1.getCar(),car1);
        assertEquals(customer2.getCar(),car2);
    }

    @Test
    public void should_return_null_when_pick_car_given_wrong_or_null_ticket(){
        ParkingLot parkingLot = new ParkingLot(5);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        Car car1 = new Car();
        Car car2 = new Car();
        Customer customer1 = new Customer(car1);
        Customer customer2 = new Customer(car2);
        customer1.parkCar(parkingBoy);
        customer2.parkCar(parkingBoy);
        customer1.setTicketLog(new TicketLog());
        customer2.setTicketLog(null);
        customer1.pickCar(parkingBoy);
        customer2.pickCar(parkingBoy);
        assertEquals(customer1.getCar(),null);
        assertEquals(customer2.getCar(),null);
    }

    @Test
    public void should_return_null_when_pick_car_given_a_ticket_already_been_used(){
        ParkingLot parkingLot = new ParkingLot(5);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        Car car1 = new Car();
        Customer customer1 = new Customer(car1);
        customer1.parkCar(parkingBoy);
        TicketLog ticketLog = customer1.getTicketLog();
        customer1.pickCar(parkingBoy);
        customer1.setTicketLog(ticketLog);
        customer1.pickCar(parkingBoy);
        assertEquals(customer1.getCar(),null);
    }

    @Test
    public void should_return_null_when_park_car_given_parkingLot_is_full(){
        ParkingLot parkingLot = new ParkingLot(1);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        Car car1 = new Car();
        Car car2 = new Car();
        Customer customer1 = new Customer(car1);
        Customer customer2 = new Customer(car2);
        customer1.parkCar(parkingBoy);
        customer2.parkCar(parkingBoy);
        assertEquals(customer1.getCar(),null);
        assertEquals(customer2.getTicketLog(),null);
        assertEquals(customer2.getCar(),car2);
    }



}
