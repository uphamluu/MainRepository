package com.phamluu.multithreading.c6CountDownLatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App {

  public static void main(String[] args) {

      CountDownLatch latch = new CountDownLatch(3);

      ExecutorService executor = Executors.newFixedThreadPool(3);

      for(int i=0; i < 3; i++) {
          executor.submit(new Processor(latch));
      }

      try {
          latch.await();
      } catch (InterruptedException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
      }

      System.out.println("Completed.");
  }

}