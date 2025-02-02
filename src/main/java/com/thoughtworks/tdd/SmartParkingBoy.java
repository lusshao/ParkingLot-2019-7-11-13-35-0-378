package com.thoughtworks.tdd;

import java.util.Comparator;

public class SmartParkingBoy extends Parker{

    public TicketLog parkCar(Car car) {
        return parkingLots.stream().sorted(Comparator.comparing(ParkingLot::getNowCapasity).reversed()).findFirst().get().parkCar(car);
    }

}
