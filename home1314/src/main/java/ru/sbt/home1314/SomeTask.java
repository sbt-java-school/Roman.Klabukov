package ru.sbt.home1314;

import java.util.concurrent.TimeUnit;

public class SomeTask implements Runnable {
    private int num;
    public SomeTask(int num) {
        this.num = num;
    }

    @Override
    public void run() {
        System.out.println("START --- " + num);
        try {
            Thread.sleep(TimeUnit.SECONDS.toMillis(2));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("END ----- " + num);
    }
}
