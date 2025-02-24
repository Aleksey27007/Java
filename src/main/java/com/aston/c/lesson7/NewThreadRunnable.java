package com.aston.c.lesson7;

public class NewThreadRunnable implements Runnable {

    Thread t;

    public NewThreadRunnable() {
        t = new Thread(this, "DemoThread");
        System.out.println("Docherni potok: " + t);
    }

    @Override
    public void run() {
        try {
            for (int i = 5; i > 0; i--) {
                System.out.println("Docherni potok: " + i);
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            System.out.println("Docherni potok prervan");
        }
        System.out.println("Zavershenie dochernego potoka");
    }
}

class ThreadDemo {
    public static void main(String[] args) {
        NewThreadRunnable nt = new NewThreadRunnable();
        nt.t.start();

        try {
            for (int i = 5; i > 0; i--) {
                System.out.println("Glavnii potok: " + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("Glavnii potok prervan");
        }
        System.out.println("Zavershenie Glavnii potok");
    }
}
