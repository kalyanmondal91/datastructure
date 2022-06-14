package com.github.concurrency;

class Shared {
    private final int MAX = 10;
    public synchronized void useResource(int n) throws InterruptedException {
        for(int i=0; i<MAX; i++){
            System.out.println(i*n);
            Thread.sleep(200);
        }
    }
}
public class Synchronization {
    public static void main(String... args) {
        Shared resource = new Shared();
        Thread thread1 = new Thread(() -> {
            try {
                resource.useResource(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread thread2 = new Thread(() -> {
            try {
                resource.useResource(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread1.start();
        thread2.start();
    }
}
