package com.phamluu.multithreading.c5ThreadPools;

class Processor implements Runnable {

  private long id;
  public Processor() {
    super();
    id= System.currentTimeMillis();
  }

  public void run() {
      System.out.println("Starting: " + id);
      System.out.println(id + " :: running");

      try {
          Thread.sleep(5000);
      } catch (InterruptedException e) {
      }

      System.out.println("Completed: " + id);
      System.out.println("------------------");
  }
}