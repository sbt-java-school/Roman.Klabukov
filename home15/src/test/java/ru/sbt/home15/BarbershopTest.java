package ru.sbt.home15;

import java.util.Random;

import static org.junit.Assert.*;


public class BarbershopTest {
    public static void main(String[] args) throws InterruptedException {
        Random random=new Random();
        for(int i=0; i<15; i++){
            Thread client=new Thread(new Client("Client"+i, 100+random.nextInt(300)), "Thread"+i);
            client.run();
        }

        System.out.println("No clients..");
        Thread.sleep(10000);
        System.out.println("Clients!");
        for(int i=10; i<20; i++){
            Thread client=new Thread(new Client("Client"+i, 100+random.nextInt(300)), "Thread"+i);
            client.run();
        }

        System.out.println("No clients..");
        Thread.sleep(9000);
        System.out.println("Clients!");
        for(int i=20; i<30; i++){
            Thread client=new Thread(new Client("Client"+i, 100+random.nextInt(300)), "Thread"+i);
            client.run();
        }

        System.out.println("No clients..");
        Thread.sleep(8000);
        System.out.println("Clients!");
        for(int i=30; i<45; i++){
            Thread client=new Thread(new Client("Client"+i, 100+random.nextInt(300)), "Thread"+i);
            client.run();
        }
    }
}