package ru.sbt.home1314;

public class ThreadWorker extends Thread {

    private BlockingQueue queue;
    private boolean isStopped = false;

    public ThreadWorker(BlockingQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run(){
        while(!isStopped()){
            try{
                Runnable runnable = (Runnable) queue.dequeue();
                runnable.run();
            } catch(Exception e){}
        }
    }


    public synchronized void doStop() {
        isStopped = true;
        this.interrupt();
    }

    public synchronized boolean isStopped() {
        return isStopped;
    }
}
