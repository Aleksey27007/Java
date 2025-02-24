package com.aston.c.lesson7;

public class NewThreadThread extends Thread{

    Thread t;

    public NewThreadThread() {
        super("Demo Thread");
        System.out.println("Docherni potok: " + this);
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

class ThreadDemo2 {
    public static void main(String[] args) {
        NewThreadThread nt = new NewThreadThread();
        nt.start();

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