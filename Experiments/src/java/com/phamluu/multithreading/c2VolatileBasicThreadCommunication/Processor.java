package com.phamluu.multithreading.c2VolatileBasicThreadCommunication;


class Processor extends Thread {

    private volatile boolean running = true;

    public void run() {

        while(running) {
            System.out.println("Running");

            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    public void shutdown() {
        running = false;
    }
}