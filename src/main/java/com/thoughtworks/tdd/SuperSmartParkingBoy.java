package com.thoughtworks.tdd;

import java.util.Comparator;

public class SuperSmartParkingBoy extends Parker{
    public TicketLog parkCar(Car car)  {
        return parkingLots.stream().sorted(Comparator.comparing(ParkingLot::getNowAvailablePositionRate).reversed()).findFirst().get().parkCar(car);
    }
}
