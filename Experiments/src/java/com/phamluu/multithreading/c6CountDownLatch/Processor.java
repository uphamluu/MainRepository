package com.phamluu.multithreading.c6CountDownLatch;

import java.util.concurrent.CountDownLatch;


class Processor implements Runnable {
  private CountDownLatch latch;

  public Processor(CountDownLatch latch) {
      this.latch = latch;
  }

  public void run() {
      System.out.println("Started.");

      try {
          Thread.sleep(3000);
      } catch (InterruptedException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
      }

      latch.countDown();
  }
}