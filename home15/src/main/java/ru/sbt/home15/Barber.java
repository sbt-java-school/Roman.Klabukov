package ru.sbt.home15;

public class Barber implements Runnable {

    private boolean sleep = true;

    public void setSleep(boolean sleep) {
        this.sleep = sleep;
    }

    public boolean isSleep() {
        return sleep;
    }

    public void cut(final Client client) throws InterruptedException {
        System.out.println("Barber cut " + client.getId());
        Thread.sleep(client.getTimeOfCutting());
        Barbershop.getInstance().barberProcessing();
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Barbershop.getInstance().barberProcessing();
            } catch (InterruptedException e) {
                break;
            }
        }
        System.out.println("Barbershop closed");
    }
}
