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



}
