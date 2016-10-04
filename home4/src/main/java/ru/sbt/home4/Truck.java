package ru.sbt.home4;


public class Truck<T> {

    private final long id;
    private final int capacity;
    private final T type;


    public Truck(final long id, final T type, final int capacity) {
        this.id = id;
        this.capacity = capacity;
        this.type = type;
    }


    public long getId() {
        return id;
    }

    public int getCapacity() {
        return capacity;
    }

    public T getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Truck{" +
                "id=" + id +
                ", capacity=" + capacity +
                ", type='" + type + '\'' +
                '}';
    }
}
