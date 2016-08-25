package home4;

/**
 * Created by rmk9 on 17.08.16.
 */
public class Truck {

    private final long id;
    private final int capacity;
    private final String label;


    public Truck(final long id, final String label, final int capacity) {
        this.id = id;
        this.capacity = capacity;
        this.label = label;

    }


    public long getId() {
        return id;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getLabel() {
        return label;
    }

    @Override
    public String toString() {
        return "Truck{" +
                "id=" + id +
                ", capacity=" + capacity +
                ", label='" + label + '\'' +
                '}';
    }
}
