package com.thoughtworks.tdd;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParkingStoryTest5 {
    @Test
    public void should_park_car_to_larger_available_position_parkingLot_when_park_car_by_smartParkingBoy() throws NullTickedProvidedException, UnrecognizedParkingTicketException, ParkingLotIsFullException {
        //given
        ParkingLot parkingLot1 = new ParkingLot(100);
        ParkingLot parkingLot2 = new ParkingLot(10);
        for(int i=0;i<9;i++){
            parkingLot2.parkCar(new Car());
        }
        parkingLot1.parkCar(new Car());
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy();
        superSmartParkingBoy.getNewParkingLot(parkingLot1);
        superSmartParkingBoy.getNewParkingLot(parkingLot2);
        Car car = new Car();
        Customer customer = new Customer(car);

        //when
        customer.parkCar(superSmartParkingBoy);

        //then
        assertEquals(parkingLot2.pickCar(customer.getTicketLog()),car);

    }
}
