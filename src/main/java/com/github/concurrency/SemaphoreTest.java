package com.github.concurrency;

import java.util.concurrent.Semaphore;

class SharedClass {
    static int count = 0;
}

class PrintThread extends Thread {

    Semaphore semaphore;
    String threadName;

    public PrintThread(Semaphore semaphore, String threadName) {
        this.semaphore = semaphore;
        this.threadName = threadName;
    }

    @Override
    public void run() {
        if(threadName.equals("ThreadA")) {
            try {
                semaphore.acquire();
                System.out.println("Thread - " + threadName);
                for(int i=0; i < 5; i++) {
                    SharedClass.count++;
                    System.out.println(threadName + ": " + SharedClass.count);
                    Thread.sleep(10);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println("Release Permit - " + threadName);
                semaphore.release();
            }
        } else if(threadName.equals("ThreadB")) {
            try {
                semaphore.acquire();
                System.out.println("Thread - " + threadName);
                for(int i=0; i < 5; i++) {
                    SharedClass.count--;
                    System.out.println(threadName + ": " + SharedClass.count);
                    Thread.sleep(10);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println("Release Permit - " + threadName);
                semaphore.release();
            }
        } else {
            System.out.println("Unknown Thread");
        }
    }
}
public class SemaphoreTest {

    public static void main(String... args) throws InterruptedException {
        Semaphore semaphore = new Semaphore(1);

        Thread thread1 = new PrintThread(semaphore, "ThreadA");
        Thread thread2 = new PrintThread(semaphore, "ThreadB");

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
    }
}
