package ru.sbt.home1314;

import org.junit.*;

import static org.junit.Assert.*;


public class ThreadPoolTest {

    @Test
    public void testThreadPool() throws Exception {
        ThreadPool threadPool = new ThreadPool(4, 4);
        for(int taskNumber = 1 ; taskNumber <= 15; taskNumber++) {
            SomeTask task = new SomeTask(taskNumber);
            threadPool.execute(task);
        }
    }


    @AfterClass
    public static void tearDownClass() {
        System.out.println("Test completed");
    }
}