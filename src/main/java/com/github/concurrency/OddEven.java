package com.github.concurrency;

public class OddEven {
    private final int n;
    private boolean isLastEven = true;

    public OddEven(int n) {
        this.n = n;
    }

    public static void main(String... args) {
        OddEven oddEven = new OddEven(20);
        Thread threadOdd = new Thread(() -> {
            try {
                oddEven.printOdd();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread threadEven = new Thread(() -> {
            try {
                oddEven.printEven();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        threadOdd.start();
        threadEven.start();
    }

    public synchronized void printOdd() throws InterruptedException {
        for(int i=1; i<n; i++) {
            if(i%2 != 0) {
                while(!isLastEven)
                    wait();
                isLastEven = false;
                System.out.println(i);
                notifyAll();
            }
        }
    }
    public synchronized void printEven() throws InterruptedException {
        for(int i=1; i<n; i++) {
            if(i%2 == 0) {
                while(isLastEven)
                    wait();
                isLastEven = true;
                System.out.println(i);
                notifyAll();
            }
        }
    }
}
