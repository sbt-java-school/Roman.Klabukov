package home4;



import java.util.*;

/**
 * Created by rmk9 on 17.08.16.
 */

public class Application {

    private Map<Long, Truck> truckRegistry = new TreeMap<>();
    private Map<String, List<Truck>> truckRegistryByType = new TreeMap<>();

    public Application(final TruckDao truckDao) {

        final List<Truck> list = truckDao.list();

        for (Truck truck : list) {

            Truck previousValue = truckRegistry.put(truck.getId(), truck);
            if(null != previousValue) {
                throw new IllegalStateException("Two truck with same Id.");
            }

            if(truckRegistryByType.containsKey(truck.getLabel())) {
                truckRegistryByType.get(truck.getLabel()).add(truck);
            } else {
                truckRegistryByType.put(truck.getLabel(), new ArrayList<>(Arrays.asList(truck)));
            }

        }

    }

    public List<Truck> getTrucksByLabel(final String label) {
        if(truckRegistryByType.containsKey(label)) {
            return truckRegistryByType.get(label);
        } else {
            throw new IllegalArgumentException("Trucks of this label not found.");
        }
    }

    public Truck getTruckById(final long id) {
        if(truckRegistry.containsKey(id)) {
            return truckRegistry.get(id);
        } else {
            throw new IllegalArgumentException("Truck witn this ID not found.");
        }
    }

    public static void main(String[] args) {
        if(args.length != 2) {
            printHelp();
        }

        TruckDao truckDao = new TruckDaoMemoryImpl();
        Application application = new Application(truckDao);

        long truckId = Long.parseLong(args[0]);
        String truckLabel = args[1];

        Truck truckById = application.getTruckById(truckId);
        List<Truck> trucksByLabel = application.getTrucksByLabel(truckLabel);

        System.out.println(trucksByLabel);

    }

    private static void printHelp() {
        System.out.println("Use argumen as truck ID.");
    }


}
