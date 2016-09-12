package home4;



import java.util.*;

public class Application <T> {

    private Map<Long, Truck> truckRegistry = new TreeMap<>();
    private Map<T, List<Truck>> truckRegistryByType = new TreeMap<>();

    public Application(final TruckDao truckDao) {

        final List<Truck> list = truckDao.list();

        for (Truck truck : list) {

            Truck previousValue = truckRegistry.put(truck.getId(), truck);
            if(null != previousValue) {
                throw new IllegalStateException("Two truck with same Id.");
            }

            if(truckRegistryByType.containsKey(truck.getType())) {
                truckRegistryByType.get(truck.getType()).add(truck);
            } else {
                truckRegistryByType.put((T)truck.getType(), new ArrayList<>(Arrays.asList(truck)));
            }

        }

    }

    public List<Truck> getTrucksByType(final T type) {
        if(truckRegistryByType.containsKey(type)) {
            return truckRegistryByType.get(type);
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

        TruckDao truckDao = new TruckDaoImplString();
        Application applicationString = new Application(truckDao);
        truckDao = new TruckDaoImplEnum();
        Application applicationEnum = new Application(truckDao);

        String truckTypeString = args[0];
        TruckEnum truckTypeEnum = TruckEnum.valueOf(args[1]);

        List<Truck> trucksByTypeString = applicationString.getTrucksByType(truckTypeString);
        List<Truck> trucksByTypeEnum = applicationEnum.getTrucksByType(truckTypeEnum);

        System.out.println(trucksByTypeString);
        System.out.println(trucksByTypeEnum);
    }

    private static void printHelp() {
        System.out.println("Use argumen as truck ID.");
    }


}
