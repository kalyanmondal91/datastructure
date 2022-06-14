package com.github.concurrency;

public class Deadlock {

    public static Object res1 = new Object();
    public static Object res2 = new Object();

    public static void main(String... args) {

        Thread thread1 = new Thread(() -> {
            synchronized(res1) {
                System.out.println("Thread 1 : Holding lock 1");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                }
                System.out.println("Thread 1: Waiting for lock 2...");
                synchronized (res2) {
                    System.out.println("Thread 1: Holding lock 1 & 2...");
                }
            }
        });

//        Thread thread2 = new Thread(() -> {
//            synchronized(res2) {
//                System.out.println("Thread 2 : Holding lock 2");
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                }
//                System.out.println("Thread 2: Waiting for lock 1...");
//                synchronized (res1) {
//                    System.out.println("Thread 2: Holding lock 1 & 2...");
//                }
//            }
//        });

        Thread thread2 = new Thread(() -> {
            synchronized(res1) {
                System.out.println("Thread 2 : Holding lock 1");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                }
                System.out.println("Thread 2: Waiting for lock 2...");
                synchronized (res2) {
                    System.out.println("Thread 2: Holding lock 1 & 2...");
                }
            }
        });

        thread1.start();
        thread2.start();
    }
}
