package ru.sbt.home1314;

import java.util.LinkedList;
import java.util.List;

public class ThreadPool {
    private BlockingQueue queue;
    private List<ThreadWorker> threads = new LinkedList<>();
    private boolean isStopped = false;

    public ThreadPool(int nThreads, int maxNTasks) {
        queue = new BlockingQueue(maxNTasks);

        for(int i = 0; i < nThreads; i++) {
            threads.add(new ThreadWorker(queue));
        }
        for (ThreadWorker thread : threads) {
            thread.start();
        }
    }

    public synchronized void execute(Runnable task) throws Exception {
        if(this.isStopped) {
            new  IllegalStateException("ThreadPool is stopped");
        }
        this.queue.enqueue(task);
    }

    public synchronized void stop() {
        this.isStopped = true;
        for (ThreadWorker thread : threads) {
            thread.doStop();
        }
    }
}
