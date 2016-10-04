package ru.sbt.home15;


public class Client implements Runnable {

    private final String id;
    private final int timeOfCutting;

    public Client(final String id, final int timeOfCutting) {
        this.id = id;
        this.timeOfCutting = timeOfCutting;
    }

    public String getId() {
        return id;
    }

    public int getTimeOfCutting() {
        return timeOfCutting;
    }

    @Override
    public void run() {
        try {
            Barbershop.getInstance().clientProcessing(this);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
