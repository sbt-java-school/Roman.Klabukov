package home4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by rmk9 on 17.08.16.
 */
public class TruckDaoMemoryImpl implements TruckDao {

    private final List<Truck> truckList = new ArrayList<>(Arrays.asList(
            new Truck(1, "VOLVO", 30),
            new Truck(2, "SCANIA", 35),
            new Truck(3, "VOLVO", 25),
            new Truck(4, "MAN", 30),
            new Truck(5, "SCANIA", 30),
            new Truck(6, "MAN", 35),
            new Truck(7, "MAN", 25),
            new Truck(8, "SCANIA", 25),
            new Truck(9, "VOLVO", 35)
    ));

    @Override
    public List<Truck> list() {
        return truckList;
    }


}
