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

}
