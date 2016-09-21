package ru.sbt.home1314;

import java.util.LinkedList;
import java.util.List;

public class BlockingQueue {
    private List queue = new LinkedList();
    private int limit;

    public BlockingQueue(int limit) {
        this.limit = limit;
    }

    public synchronized void enqueue(Object object) throws InterruptedException {
        while(this.queue.size() == this.limit) {
            wait();
        }
        if(this.queue.size() == 0) {
            notifyAll();
        }
        this.queue.add(object);
    }

    public synchronized Object dequeue() throws InterruptedException {
        while(this.queue.size() == 0) {
            wait();
        }
        if(this.queue.size() == this.limit) {
            notifyAll();
        }
        return this.queue.remove(0);
    }

}
