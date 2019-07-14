package com.thoughtworks.tdd;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private final int capasity;
    private Map<TicketLog,Car> cars;

    public ParkingLot(int capasity) {
        this.capasity = capasity;
        this.cars = new HashMap<TicketLog,Car>();
    }


    public TicketLog parkCar(Car car) {
        if(capasity <= cars.size()){
            return null;
        }
        TicketLog ticketLog = new TicketLog();
        cars.put(ticketLog,car);
        return ticketLog;
    }

    public Car pickCar(TicketLog ticketLog) {
        return cars.get(ticketLog);
    }
}
