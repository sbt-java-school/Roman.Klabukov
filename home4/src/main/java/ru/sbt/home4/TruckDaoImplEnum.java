package ru.sbt.home4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TruckDaoImplEnum implements TruckDao {

    private final List<Truck> truckList = new ArrayList<>(Arrays.asList(
            new Truck(1, TruckEnum.MAN, 30),
            new Truck(2, TruckEnum.SCANIA, 35),
            new Truck(3, TruckEnum.VOLVO, 25),
            new Truck(4, TruckEnum.VOLVO, 30),
            new Truck(5, TruckEnum.SCANIA, 30),
            new Truck(6, TruckEnum.MAN, 35),
            new Truck(7, TruckEnum.MAN, 25),
            new Truck(8, TruckEnum.SCANIA, 25),
            new Truck(9, TruckEnum.VOLVO, 35)
    ));

    public List<Truck> list() {
        return truckList;
    }


}