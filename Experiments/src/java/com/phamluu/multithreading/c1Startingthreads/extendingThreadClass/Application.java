package com.phamluu.multithreading.c1Startingthreads.extendingThreadClass;

public class Application {


  public static void main(String[] args) {
      Runner runner1 = new Runner();
      runner1.start();

      Runner runner2 = new Runner();
      runner2.start();

  }

}