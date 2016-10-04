package ru.sbt.home15;


import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class Barbershop {

    public static final int NUMBER_OF_CHAIRS = 5;
    private Barber barber = new Barber();
    private static Barbershop instance;
    BlockingQueue<Client> chairs = new ArrayBlockingQueue<Client>(NUMBER_OF_CHAIRS);

    private final Lock lock = new ReentrantLock();

    public static Barbershop getInstance() {
        if (instance == null) {
            synchronized (Barbershop.class) {
                if (instance == null) {
                    instance = new Barbershop();
                }
            }
        }
        return instance;
    }

    public void clientProcessing(final Client client) throws InterruptedException {

        lock.lock();

            Thread.sleep(1000);
            if(barber.isSleep()) {
                barber.setSleep(false);
                lock.unlock();
                processing(client);
            } else {
                Thread.sleep(500);
                chairs.put(client);
                lock.unlock();
            }


    }

    public void barberProcessing() throws InterruptedException {
        lock.lock();

            Thread.sleep(500);
            if(chairs.isEmpty()) {
                barber.setSleep(true);
                lock.unlock();
            } else {
                barber.setSleep(false);
                Thread.sleep(500);
                lock.unlock();
                processing(chairs.take());
            }

    }

    public void processing(Client client) throws InterruptedException {
        barber.cut(client);
    }



}