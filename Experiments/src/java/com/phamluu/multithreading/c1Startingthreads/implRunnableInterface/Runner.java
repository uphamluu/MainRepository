package com.phamluu.multithreading.c1Startingthreads.implRunnableInterface ;

class Runner implements Runnable {

  public void run() {
      for(int i=0; i<5; i++) {
          System.out.println("Hello: " + i);

          try {
              Thread.sleep(100);
          } catch (InterruptedException e) {
              // TODO Auto-generated catch block
              e.printStackTrace();
          }
      }

  }

}