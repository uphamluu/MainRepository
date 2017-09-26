package com.phamluu.multithreading.c1Startingthreads.implRunnableInterface;


public class Application {


  public static void main(String[] args) {
      Thread thread1 = new Thread(new Runner());
      thread1.start();
  }

}