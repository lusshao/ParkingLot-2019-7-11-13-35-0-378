package com.thoughtworks.tdd;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private final int capasity;
    private Map<TicketLog, Car> cars;

    public ParkingLot(int capasity) {
        this.capasity = capasity;
        this.cars = new HashMap<TicketLog, Car>();
    }


    public TicketLog parkCar(Car car) throws ParkingLotIsFullException {
        if (capasity <= cars.size()) {
            throw new ParkingLotIsFullException();
        }
        TicketLog ticketLog = new TicketLog();
        cars.put(ticketLog, car);
        return ticketLog;
    }

    public Car pickCar(TicketLog ticketLog) throws UnrecognizedParkingTicketException, NullTickedProvidedException {
        if (ticketLog == null) {
            throw new NullTickedProvidedException();
        }
        if (!cars.containsKey(ticketLog)) {
            throw new UnrecognizedParkingTicketException();
        }
        Car car = cars.get(ticketLog);
        cars.remove(ticketLog);
        return car;
    }

    public int getNowCapasity() {
        return capasity-cars.size();
    }

    public boolean hasTicketLog(TicketLog ticketLog) {
        return cars.containsKey(ticketLog);
    }
}
